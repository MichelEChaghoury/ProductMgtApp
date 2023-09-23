package com.ultims.productmgt.comandservice.product.segregate.handler;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.ultims.productmgt.comandservice.product.dto.CreateProductDto;
import com.ultims.productmgt.comandservice.product.dto.ProductDto;
import com.ultims.productmgt.comandservice.product.segregate.event.ProductCreatedEvent;
import com.ultims.productmgt.comandservice.product.service.ProductService;

@Component
public class ProductEventHandler {
    private final ProductService productService;

    public ProductEventHandler(ProductService productService) {
        this.productService = productService;
    }

    @EventHandler
    public ProductDto on(ProductCreatedEvent event) {
        CreateProductDto dto = CreateProductDto.builder()
                .name(event.getName())
                .description(event.getDescription())
                .quantity(event.getQuantity())
                .unitPrice(event.getUnitPrice())
                .build();

        return productService.add(dto);
    }
}
