package com.target.demo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.target.demo.client.TargetApiClient;
import com.target.demo.entity.ProductEntity;
import com.target.demo.entity.ProductMapper;
import com.target.demo.model.CustomError;
import com.target.demo.model.Product;
import com.target.demo.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by rohit on 6/16/17.
 */
@Service
public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
    private final ProductMapper mapper = ProductMapper.INSTANCE;

    @Resource
    private ProductRepository productRepository;

    @Resource
    private TargetApiClient apiClient;

    public Product getProduct(Long id) {
        Optional<Product> product = Optional.empty();
        CompletableFuture<String> getName = CompletableFuture.supplyAsync(() -> {
            logger.info("getting product name against id");
            JsonNode json = apiClient.getPriceData(id);
            return json.get("product_composite_response").get("items").get(0).get("online_description").get("value").asText();
        });
        CompletableFuture<ProductEntity> getPrice = CompletableFuture.supplyAsync(() -> {
            logger.info("getting product price against id");
            return productRepository.findOne(id);
        });
        CompletableFuture<Product> getProduct = getName.thenCombine(getPrice,(productName,productEntity) -> mapper.toProduct(productRepository.save(productEntity), productName));
        try {
           product = Optional.of(getProduct.get());
        } catch (InterruptedException|ExecutionException e) {
            logger.error(e.getMessage());
        }
        return product.orElseThrow(() -> new IllegalArgumentException("No product found against id"));
    }

    public Product updateProduct(Long id, Product product) {
        logger.info("updating product price against id");
        return mapper.toProduct(productRepository.save(mapper.toProductEntity(product)), product.getName());
    }
}
