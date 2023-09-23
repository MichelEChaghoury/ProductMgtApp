package com.ultims.productmgt.queryservice.product.service;

import java.util.List;
import java.util.UUID;

import com.ultims.productmgt.queryservice.product.dto.ProductDto;

public interface ProductService {
    List<ProductDto> get();

    ProductDto get(UUID id);
}
