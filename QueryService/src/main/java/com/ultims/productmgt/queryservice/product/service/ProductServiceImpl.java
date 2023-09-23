package com.ultims.productmgt.queryservice.product.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ultims.productmgt.queryservice.product.dto.ProductDto;
import com.ultims.productmgt.queryservice.product.entity.Product;
import com.ultims.productmgt.queryservice.product.mapper.ProductMapper;
import com.ultims.productmgt.queryservice.product.repository.ProductRepository;
import com.ultims.productmgt.queryservice.shared.exception.NotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDto> get() {
        return productRepository
                .findAll()
                .stream()
                .map(productMapper::toDto)
                .toList();
    }

    @Override
    public ProductDto get(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("Invalid Input. Product ID can not be null");
        }

        Product product = productRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("No Product with ID " + id + " was found"));

        return productMapper.toDto(product);
    }

}
