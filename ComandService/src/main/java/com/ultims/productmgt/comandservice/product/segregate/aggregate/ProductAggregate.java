package com.ultims.productmgt.comandservice.product.segregate.aggregate;

import java.math.BigDecimal;
import java.util.UUID;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.ultims.productmgt.comandservice.product.segregate.command.CreateProductCommand;
import com.ultims.productmgt.comandservice.product.segregate.event.ProductCreatedEvent;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private UUID id;
    private String name;
    private String description;
    private BigDecimal quantity;
    private BigDecimal unitPrice;

    public ProductAggregate() {
    }

    @CommandHandler
    public ProductAggregate(CreateProductCommand command) {
        // TODO: perform validation
        ProductCreatedEvent event = ProductCreatedEvent.builder()
                .id(command.getId())
                .name(command.getName())
                .description(command.getDescription())
                .quantity(command.getQuantity())
                .unitPrice(command.getUnitPrice())
                .build();

        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent event) {
        id = event.getId();
        name = event.getName();
        description = event.getDescription();
        quantity = event.getQuantity();
        unitPrice = event.getUnitPrice();
    }
}
