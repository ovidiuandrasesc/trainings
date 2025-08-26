package com.example.marketapp.product;

import com.example.marketapp.product.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO getProductById(String id);

    List<ProductDTO> getAllProducts();

    ProductDTO updateProduct(String id, ProductDTO productDTO);

    void decreaseStock(String id, int quantity);

    void deleteProduct(String id);
}
