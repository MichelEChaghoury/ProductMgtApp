package com.ultims.productmgt.comandservice.product.mapper;

import java.util.UUID;

import com.ultims.productmgt.comandservice.product.dto.CreateProductDto;
import com.ultims.productmgt.comandservice.product.dto.ProductDto;
import com.ultims.productmgt.comandservice.product.dto.UpdateProductDto;
import com.ultims.productmgt.comandservice.product.entity.Product;

public interface ProductMapper {
    ProductDto toDto(Product product);

    ProductDto toDto(CreateProductDto dto);

    ProductDto toDto(UpdateProductDto dto, UUID id);

    Product toProduct(ProductDto dto);

    Product toProduct(CreateProductDto dto);

    Product toProduct(UpdateProductDto dto, UUID id);
}
