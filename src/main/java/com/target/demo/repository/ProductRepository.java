package com.target.demo.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.target.demo.entity.ProductEntity;
import com.target.demo.entity.ProductMapper;
import com.target.demo.model.CurrencyCode;
import com.target.demo.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * Created by rohit on 6/16/17.
 */
@Repository
public class ProductRepository {

    private static final Logger logger = LoggerFactory.getLogger(ProductRepository.class);

    @Resource
    private DynamoDBMapper dynamoDB;

    /*@PostConstruct
    private void init() {
        Product p1 = new Product(13860428, "The Big Lebowski (Blu-ray)", BigDecimal.TEN, CurrencyCode.USD);
        Product p2 = new Product(13860429, "SpongeBob SquarePants: SpongeBob's Frozen Face-off", BigDecimal.TEN, CurrencyCode.USD);
        ProductMapper mapper = ProductMapper.INSTANCE;
        ProductEntity pe1 = mapper.toProductEntity(p1);
        ProductEntity pe2 = mapper.toProductEntity(p2);
        dynamoDB.save(pe1);
        dynamoDB.save(pe2);
    }*/

    public ProductEntity findOne(Long id) {
        return dynamoDB.load(ProductEntity.class,id);
    }

    public ProductEntity save(ProductEntity product) {
        ProductEntity one = dynamoDB.load(ProductEntity.class, product.getId());
        if(product.getCurrentPrice()!=null){
            if(product.getCurrentPrice().getValue()!=null){
                one.getCurrentPrice().setValue(product.getCurrentPrice().getValue());
            }
            if(product.getCurrentPrice().getCurrencyCode()!=null){
                one.getCurrentPrice().setCurrencyCode(product.getCurrentPrice().getCurrencyCode());
            }
        }
        dynamoDB.save(one);
        return one;
    }
}
