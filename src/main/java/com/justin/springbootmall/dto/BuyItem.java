package com.justin.springbootmall.dto;

import jakarta.validation.constraints.NotNull;

public class BuyItem {

    @NotNull
    private Integer productId; // 什麼產品

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @NotNull
    private Integer quantity; // 多少數量

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }



}
