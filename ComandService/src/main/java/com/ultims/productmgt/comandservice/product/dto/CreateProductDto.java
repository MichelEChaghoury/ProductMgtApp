package com.ultims.productmgt.comandservice.product.dto;

import java.math.BigDecimal;

import lombok.Builder;

@Builder
public record CreateProductDto(
        String name,
        String description,
        BigDecimal quantity,
        BigDecimal unitPrice) {
}
