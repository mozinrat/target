package com.target.demo;

import com.target.demo.model.Product;
import com.target.demo.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.math.BigDecimal;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Resource
    private ProductService productService;

	@Test
	public void contextLoads() {
	}

	@Test
    public void testGetProduct(){
        Product product = productService.getProduct(13860428l);
        assertTrue(product.getId() ==13860428l);
        assertTrue(product.getName().equals("The Big Lebowski (Blu-ray)"));
        assertNotNull(product.getCurrentPrice().getValue());
    }

    @Test
    public void testPutProduct(){
        Product product = productService.getProduct(13860428l);
        product.getCurrentPrice().setValue(BigDecimal.ONE);
        product = productService.updateProduct(product.getId(),product);
        assertTrue(product.getCurrentPrice().getValue().equals(BigDecimal.ONE));
    }


}
