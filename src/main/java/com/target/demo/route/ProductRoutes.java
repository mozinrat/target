package com.target.demo.route;

import com.target.demo.model.Product;
import com.target.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


/**
 * Created by rohit on 6/16/17.
 */
@RestController
@RequestMapping("/products")
public class ProductRoutes {

    @Resource
    private ProductService productService;

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Product getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }


}
