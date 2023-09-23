package com.ultims.productmgt.queryservice.product.dto;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

import com.ultims.productmgt.queryservice.product.entity.Product;

import lombok.Builder;

@Builder
public class ProductDto {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal quantity;
    private BigDecimal unitPrice;

    public ProductDto() {
    }

    public ProductDto(String name, String description, BigDecimal quantity, BigDecimal unitPrice) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public ProductDto(UUID id, String name, String description, BigDecimal quantity, BigDecimal unitPrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
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
        return "ProductDto{" + "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
