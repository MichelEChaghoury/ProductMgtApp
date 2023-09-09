package com.ultims.productmgt.queryservice.service;

import com.ultims.productmgt.queryservice.dto.ProductDto;
import com.ultims.productmgt.queryservice.entity.Product;
import com.ultims.productmgt.queryservice.mapper.ProductMapper;
import com.ultims.productmgt.queryservice.repository.ProductRepository;
import com.ultims.productmgt.queryservice.shared.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
    public ProductDto get(UUID productId) {

        if (productId == null) {
            throw new IllegalArgumentException("Invalid Input. Product ID can not be null");
        }

        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new NotFoundException("No Product with ID: " + productId + " was found"));

        return productMapper.toDto(product);
    }
}
