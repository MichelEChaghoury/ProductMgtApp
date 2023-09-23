package com.ultims.productmgt.queryservice.product.mapper;

import org.springframework.stereotype.Component;

import com.ultims.productmgt.queryservice.product.dto.ProductDto;
import com.ultims.productmgt.queryservice.product.entity.Product;

@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto toDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .quantity(product.getQuantity())
                .unitPrice(product.getUnitPrice())
                .build();
    }

    @Override
    public Product toProduct(ProductDto dto) {
        return Product.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .quantity(dto.getQuantity())
                .unitPrice(dto.getUnitPrice())
                .build();
    }

}
