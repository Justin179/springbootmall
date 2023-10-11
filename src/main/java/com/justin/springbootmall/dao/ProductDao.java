package com.justin.springbootmall.dao;

import com.justin.springbootmall.dto.ProductRequest;
import com.justin.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
