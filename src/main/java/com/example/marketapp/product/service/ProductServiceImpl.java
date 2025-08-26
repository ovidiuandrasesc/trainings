package com.example.marketapp.product.service;

import com.example.marketapp.product.ProductService;
import com.example.marketapp.product.dto.ProductDTO;
import com.example.marketapp.product.entity.ProductEntity;
import com.example.marketapp.product.mapper.ProductMapper;
import com.example.marketapp.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        ProductEntity productEntity = productMapper.toEntity(productDTO);
        productEntity = productRepository.save(productEntity);
        return productMapper.toDTO(productEntity);
    }

    @Override
    public ProductDTO getProductById(String id) {
        return productRepository.findById(id)
                .map(productMapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toDTO)
                .toList();
    }

    @Override
    @Transactional
    public ProductDTO updateProduct(String id, ProductDTO productDTO) {
        return productRepository.findById(id)
                .map(existingProductEntity -> {
                    ProductEntity updatedProductEntity = productMapper.toEntity(productDTO);
                    updatedProductEntity.setId(existingProductEntity.getId()); // Preserve the ID
                    updatedProductEntity = productRepository.save(updatedProductEntity);
                    return productMapper.toDTO(updatedProductEntity);
                })
                .orElse(null);
    }

    @Override
    @Transactional
    public void decreaseStock(String id, int quantity) {
        ProductEntity entity = productRepository.findById(id).orElseThrow();
        entity.decreaseQuantity(quantity);
    }

    @Override
    public void deleteProduct(String id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Product with ID " + id + " does not exist.");
        }
    }
}
