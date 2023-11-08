package com.justin.springbootmall.dao.impl;

import com.justin.springbootmall.dao.ProductDao;
import com.justin.springbootmall.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductDaoImplTest {

    @Autowired
    private ProductDao productDao;

    @Test
    void getProductById() {
        Product product = productDao.getProductById(9);
        assertEquals("BMW", product.getProductName());
    }

    @Test
    @Transactional
    void deleteById(){
        productDao.deleteProductById(9);
        Product product = productDao.getProductById(9);
        assertNull(product);
    }
}