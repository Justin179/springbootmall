package com.justin.springbootmall.service.impl;

import com.justin.springbootmall.dao.OrderDao;
import com.justin.springbootmall.dao.ProductDao;
import com.justin.springbootmall.dto.BuyItem;
import com.justin.springbootmall.dto.CreateOrderRequest;
import com.justin.springbootmall.model.OrderItem;
import com.justin.springbootmall.model.Product;
import com.justin.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {

        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for (BuyItem buyItem : createOrderRequest.getBuyItemList()) {
            Product product = productDao.getProductById(buyItem.getProductId());

            // 計算總價錢
            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount = totalAmount + amount;

            // BuyItem to OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);

            // 檢查 product 是否存在、庫存是否足夠
//            if (product == null) {
//                log.warn("商品 {} 不存在", buyItem.getProductId());
//                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//
//            } else if (product.getStock() < buyItem.getQuantity()) {
//                log.warn("商品 {} 庫存數量不足，無法購買。剩餘庫存 {}，欲購買數量 {}",
//                        buyItem.getProductId(), product.getStock(), buyItem.getQuantity());
//                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//            }

            // 扣除商品庫存
//            productDao.updateStock(product.getProductId(), product.getStock() - buyItem.getQuantity());




            // 轉換 BuyItem to OrderItem
//            OrderItem orderItem = new OrderItem();
//            orderItem.setProductId(buyItem.getProductId());
//            orderItem.setQuantity(buyItem.getQuantity());
//            orderItem.setAmount(amount);
//
//            orderItemList.add(orderItem);
        }

        // 創建一筆訂單
        Integer orderId = orderDao.createOrder(userId,totalAmount);
        // 與該訂單的品項
        orderDao.createOrderItems(orderId, orderItemList);

        return orderId;
    }
}
