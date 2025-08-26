package com.example.marketapp.order;

import com.example.marketapp.order.dto.OrderDto;

public interface OrderService {
    String createOrder(OrderDto orderDto);
    void cancelOrder(String orderId);
    void completeOrder(String orderId);
}
