package com.example.marketapp.order.dto;

public record StripePaymentDto(
    String stripeCustomerId,
    String stripeCheckoutSessionId,
    String stripePaymentMethodId) {
}
