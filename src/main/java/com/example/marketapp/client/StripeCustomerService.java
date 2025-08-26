package com.example.marketapp.client;

import com.stripe.exception.StripeException;

public interface StripeCustomerService {
    String createCustomer(String name, String email,String phone) throws StripeException;
}
