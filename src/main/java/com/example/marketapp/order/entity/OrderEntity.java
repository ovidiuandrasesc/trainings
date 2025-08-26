package com.example.marketapp.order.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "orders")
@Data
public class OrderEntity {
    @Id
    private String id;
    private String clientId;
    private String productId;
    private double totalPrice;
    private String status;
    private StripePayment stripePayment;
    private List<CheckoutProduct> orderedProducts;
}
