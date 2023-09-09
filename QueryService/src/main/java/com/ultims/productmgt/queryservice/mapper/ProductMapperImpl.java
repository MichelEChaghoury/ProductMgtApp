package com.ultims.productmgt.queryservice.mapper;

import com.ultims.productmgt.queryservice.dto.ProductDto;
import com.ultims.productmgt.queryservice.entity.Product;
import org.springframework.context.annotation.Configuration;

@Configuration
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
    public Product toProduct(ProductDto productDto) {
        return Product.builder()
            .id(productDto.id())
            .name(productDto.name())
            .description(productDto.description())
            .quantity(productDto.quantity())
            .unitPrice(productDto.unitPrice())
            .build();
    }
}
