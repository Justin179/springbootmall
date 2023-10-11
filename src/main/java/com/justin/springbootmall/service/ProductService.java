package com.justin.springbootmall.service;

import com.justin.springbootmall.dto.ProductRequest;
import com.justin.springbootmall.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
