package com.ultims.productmgt.queryservice.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record ProductDto(
    UUID id,
    String name,
    String description,
    BigDecimal quantity,
    BigDecimal unitPrice) {
}
