package com.ultims.productmgt.comandservice.product.mapper;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.ultims.productmgt.comandservice.product.dto.CreateProductDto;
import com.ultims.productmgt.comandservice.product.dto.ProductDto;
import com.ultims.productmgt.comandservice.product.dto.UpdateProductDto;
import com.ultims.productmgt.comandservice.product.entity.Product;

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
    public ProductDto toDto(CreateProductDto dto) {
        return ProductDto.builder()
                .name(dto.name())
                .description(dto.description())
                .unitPrice(dto.unitPrice())
                .quantity(dto.quantity())
                .build();
    }

    @Override
    public ProductDto toDto(UpdateProductDto dto, UUID id) {
        return ProductDto.builder()
                .id(id)
                .name(dto.name())
                .description(dto.description())
                .unitPrice(dto.unitPrice())
                .quantity(dto.quantity())
                .build();
    }

    @Override
    public Product toProduct(ProductDto dto) {
        return Product.builder()
                .id(dto.id())
                .name(dto.name())
                .description(dto.description())
                .quantity(dto.quantity())
                .unitPrice(dto.unitPrice())
                .build();
    }

    @Override
    public Product toProduct(CreateProductDto dto) {
        return Product.builder()
                .name(dto.name())
                .description(dto.description())
                .unitPrice(dto.unitPrice())
                .quantity(dto.quantity())
                .build();
    }

    @Override
    public Product toProduct(UpdateProductDto dto, UUID id) {
        return Product.builder()
                .id(id)
                .name(dto.name())
                .description(dto.description())
                .unitPrice(dto.unitPrice())
                .quantity(dto.quantity())
                .build();
    }
}
