package com.ultims.productmgt.queryservice.service;

import com.ultims.productmgt.queryservice.dto.ProductDto;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<ProductDto> get();

    ProductDto get(UUID productId);
}
