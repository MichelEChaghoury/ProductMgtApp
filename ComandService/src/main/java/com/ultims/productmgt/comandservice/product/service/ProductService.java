package com.ultims.productmgt.comandservice.product.service;

import java.util.UUID;

import com.ultims.productmgt.comandservice.product.dto.CreateProductDto;
import com.ultims.productmgt.comandservice.product.dto.ProductDto;
import com.ultims.productmgt.comandservice.product.dto.UpdateProductDto;

public interface ProductService {
    ProductDto add(CreateProductDto dto);

    ProductDto update(UUID id, UpdateProductDto dto);
}
