package com.example.marketapp.order;

import com.example.marketapp.order.dto.StripePaymentDto;
import com.stripe.exception.StripeException;

public interface StripeOrderService {
    StripePaymentDto createStripePayment(String clientId, String stripeCustomerId, double price) throws StripeException;
}
