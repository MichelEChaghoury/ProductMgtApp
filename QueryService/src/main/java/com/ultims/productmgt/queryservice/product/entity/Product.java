package com.ultims.productmgt.queryservice.product.entity;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Table(name = "products")
@Builder
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    public Product() {
    }

    public Product(String name, String description, BigDecimal quantity, BigDecimal unitPrice) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public Product(UUID id, String name, String description, BigDecimal quantity, BigDecimal unitPrice) {
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
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(quantity, product.quantity) &&
                Objects.equals(unitPrice, product.unitPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, quantity, unitPrice);
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
