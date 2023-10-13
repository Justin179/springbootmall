package com.justin.springbootmall.service;

import com.justin.springbootmall.dto.CreateOrderRequest;
import com.justin.springbootmall.dto.OrderQueryParams;
import com.justin.springbootmall.model.Order;

import java.util.List;

public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Integer countOrder(OrderQueryParams orderQueryParams);
}
