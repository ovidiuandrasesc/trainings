package com.example.marketapp.order.entity;

import lombok.Data;

@Data
public class StripePayment {
    private String stripeProductId;
    private String stripePriceId;
    private String stripeCheckoutSessionId;
    private String stripePaymentIntentId;
    private String stripeSubscriptionId;
    private String stripeCustomerId;
    private String stripePaymentMethodId;
}
