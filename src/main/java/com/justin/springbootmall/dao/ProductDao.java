package com.justin.springbootmall.dao;

import com.justin.springbootmall.constant.ProductCategory;
import com.justin.springbootmall.dto.ProductQueryParams;
import com.justin.springbootmall.dto.ProductRequest;
import com.justin.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Integer countProduct(ProductQueryParams productQueryParams);

    void updateStock(Integer productId, int stock);
}
