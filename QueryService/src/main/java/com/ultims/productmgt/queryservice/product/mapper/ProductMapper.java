package com.ultims.productmgt.queryservice.product.mapper;

import com.ultims.productmgt.queryservice.product.dto.ProductDto;
import com.ultims.productmgt.queryservice.product.entity.Product;

public interface ProductMapper {
    ProductDto toDto(Product product);

    Product toProduct(ProductDto dto);
}
