package com.ultims.productmgt.comandservice.product.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ultims.productmgt.comandservice.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
}
