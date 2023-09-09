package com.ultims.productmgt.queryservice.mapper;

import com.ultims.productmgt.queryservice.dto.ProductDto;
import com.ultims.productmgt.queryservice.entity.Product;

public interface ProductMapper {
    ProductDto toDto(Product product);

    Product toProduct(ProductDto productDto);
}
