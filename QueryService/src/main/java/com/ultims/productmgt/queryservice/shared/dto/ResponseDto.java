package com.ultims.productmgt.queryservice.shared.dto;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record ResponseDto(
    Object body,
    HttpStatus httpStatus
) {
}
