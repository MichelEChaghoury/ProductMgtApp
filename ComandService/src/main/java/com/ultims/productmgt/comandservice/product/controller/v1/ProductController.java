package com.ultims.productmgt.comandservice.product.controller.v1;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ultims.productmgt.comandservice.product.dto.CreateProductDto;
import com.ultims.productmgt.comandservice.product.dto.ProductDto;
import com.ultims.productmgt.comandservice.product.dto.UpdateProductDto;
import com.ultims.productmgt.comandservice.product.route.v1.ProductRoute;
import com.ultims.productmgt.comandservice.product.segregate.command.CreateProductCommand;

@RestController
public class ProductController {

    private final CommandGateway commandGateway;

    public ProductController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping(ProductRoute.CREATE)
    public ResponseEntity<UUID> add(@RequestBody CreateProductDto dto) {
        CreateProductCommand command = CreateProductCommand.builder()
                .id(UUID.randomUUID())
                .name(dto.name())
                .description(dto.description())
                .quantity(dto.quantity())
                .unitPrice(dto.unitPrice())
                .build();

        UUID id = (UUID) commandGateway.sendAndWait(command);

        return ResponseEntity.ok(id);
    }

    @PutMapping(ProductRoute.UPDATE_BY_ID)
    public ResponseEntity<ProductDto> update(@PathVariable("id") UUID id, @RequestBody UpdateProductDto dto) {
        return null;
    }
}
