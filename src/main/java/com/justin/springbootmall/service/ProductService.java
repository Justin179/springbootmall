package com.justin.springbootmall.service;

import com.justin.springbootmall.constant.ProductCategory;
import com.justin.springbootmall.dto.ProductQueryParams;
import com.justin.springbootmall.dto.ProductRequest;
import com.justin.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProduct(Integer productId);

    List<Product> getProducts(ProductQueryParams productQueryParams);
}
