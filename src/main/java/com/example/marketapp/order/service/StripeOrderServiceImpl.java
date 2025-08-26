package com.example.marketapp.order.service;

import com.example.marketapp.order.StripeOrderService;
import com.example.marketapp.order.dto.StripePaymentDto;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.stereotype.Service;

@Service
public class StripeOrderServiceImpl implements StripeOrderService {

    @Override
    public StripePaymentDto createStripePayment(String clientId, String stripeCustomerId, double price) throws StripeException {
        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                .setAmount((long) (price * 100)) // Stripe expects cents
                .setCurrency("usd")
                .setCustomer(stripeCustomerId)
                .setDescription("Payment for client Order " + clientId)
                .build();

        PaymentIntent paymentIntent = PaymentIntent.create(params);
        paymentIntent.
        StripePaymentDto dto = new StripePaymentDto(stripeCustomerId, paymentIntent.getInvoiceObject().getCharge(),
                paymentIntent.getId(), paymentIntent.getStatus()));
        return null;
    }
}
