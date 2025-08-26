package com.example.marketapp.order.entity;

import lombok.Data;

@Data
public class StripePayment {
    private String stripeCustomerId;
    private String stripeInvoiceId;
}
