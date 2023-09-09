package com.ultims.productmgt.queryservice.repository;

import com.ultims.productmgt.queryservice.entity.Product;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
}
