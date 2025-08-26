package com.example.marketapp.product.dto;

public record ProductDTO(
        String id,
        String name,
        String description,
        Double price,
        String category,
        String imageUrl,
        Integer stockQuantity,
        String createdAt,
        String updatedAt
) {}
