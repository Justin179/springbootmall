package com.justin.springbootmall.service.impl;

import com.justin.springbootmall.dao.ProductDao;
import com.justin.springbootmall.model.Product;
import com.justin.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
