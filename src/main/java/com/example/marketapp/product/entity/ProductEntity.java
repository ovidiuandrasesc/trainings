package com.example.marketapp.product.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
@Data
public class ProductEntity {

    @Id
    private String id;
    private String name;
    private String description;
    private Double price;
    private String category;
    private String imageUrl;
    private Integer stockQuantity;
    private String createdAt;
    private String updatedAt;

    public void decreaseQuantity(int quantity) {
        if (this.stockQuantity != null && this.stockQuantity >= quantity) {
            this.stockQuantity -= quantity;
        } else {
            throw new IllegalArgumentException("Insufficient stock");
        }
    }
}
