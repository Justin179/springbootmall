package com.justin.springbootmall.service;

import com.justin.springbootmall.dto.CreateOrderRequest;
import com.justin.springbootmall.model.Order;

public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);
}
