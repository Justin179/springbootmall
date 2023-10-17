package com.justin.springbootmall.service.impl;

import com.justin.springbootmall.dao.ProductDao;
import com.justin.springbootmall.model.Product;
import com.justin.springbootmall.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.nio.file.SecureDirectoryStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceImplMockTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductDao productDao;

    @Test
    public void getById(){
        Product mockProduct = new Product();
        mockProduct.setProductName("蘋果（非洲）");
        Mockito.when(productDao.getProductById(Mockito.anyInt())).thenReturn(mockProduct);

        Product product = productService.getProductById(5);
        assertEquals("蘋果（非洲）", product.getProductName());
    }

}