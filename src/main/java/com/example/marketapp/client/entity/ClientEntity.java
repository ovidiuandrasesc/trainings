package com.example.marketapp.client.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class ClientEntity {
    @Id
    private String id;
    private String stripeCustomerId;
    private String stripePaymentMethodId;
    private String stripeSubscriptionId;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;

}
