package com.example.marketapp.client.dto;

public record ClientDto( String id,
         String stripeCustomerId,
         String name,
         String email,
         String phoneNumber,
         String address){
}
