package com.ultims.productmgt.comandservice.product.segregate.command;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.ultims.productmgt.comandservice.product.entity.Product;

import lombok.Builder;

@Builder
public class CreateProductCommand {

    @TargetAggregateIdentifier
    private final UUID id;
    private final String name;
    private final String description;
    private final BigDecimal quantity;
    private final BigDecimal unitPrice;

    public CreateProductCommand(UUID id, String name, String description, BigDecimal quantity, BigDecimal unitPrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Product product = (Product) o;
        return Objects.equals(id, product.getId()) &&
                Objects.equals(name, product.getName()) &&
                Objects.equals(description, product.getDescription()) &&
                Objects.equals(quantity, product.getQuantity()) &&
                Objects.equals(unitPrice, product.getUnitPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, quantity, unitPrice);
    }

    @Override
    public String toString() {
        return "CreateProductCommand{" + "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
