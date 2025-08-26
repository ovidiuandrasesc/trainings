package com.example.marketapp.client.service;

import com.example.marketapp.client.StripeCustomerService;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StripeCustomerServiceImpl implements StripeCustomerService {

    @Override
    public String createCustomer(String name, String email, String phone) throws StripeException {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("email", email);
        params.put("phone", phone);

        return Customer.create(params).getId();
    }
}
