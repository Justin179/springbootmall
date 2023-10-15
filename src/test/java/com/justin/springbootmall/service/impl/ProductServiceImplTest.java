package com.justin.springbootmall.service.impl;

import com.justin.springbootmall.model.Product;
import com.justin.springbootmall.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Test
    void getProductById() {
        Product product = productService.getProductById(9);
        assertNotNull(product);
        assertEquals("BMW",product.getProductName());
    }
}