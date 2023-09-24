package com.ultims.productmgt.queryservice.product.segregate.query;

import java.util.Objects;
import java.util.UUID;

import com.ultims.productmgt.queryservice.product.entity.Product;

public class GetProductByIdQuery {

    private final UUID id;

    public GetProductByIdQuery(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Product product = (Product) o;
        return Objects.equals(id, product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "GetProductByIdQuery{" + "id=" + id + '}';
    }
}
