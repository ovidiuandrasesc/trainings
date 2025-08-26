package com.example.marketapp.order.dto;

import java.util.List;

public record OrderDto(String clientId,
                       String stripeCustomerId,
                       List<CheckoutProductDto>orderedProducts) {

    public record CheckoutProductDto(String productId, int quantity, double price) {

    }
}
