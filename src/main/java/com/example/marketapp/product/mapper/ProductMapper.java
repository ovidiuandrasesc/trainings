package com.example.marketapp.product.mapper;

import com.example.marketapp.product.dto.ProductDTO;
import com.example.marketapp.product.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDTO(ProductEntity productEntity);

    ProductEntity toEntity(ProductDTO productDTO);
}
