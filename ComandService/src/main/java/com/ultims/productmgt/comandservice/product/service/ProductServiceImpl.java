package com.ultims.productmgt.comandservice.product.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ultims.productmgt.comandservice.product.dto.CreateProductDto;
import com.ultims.productmgt.comandservice.product.dto.ProductDto;
import com.ultims.productmgt.comandservice.product.dto.UpdateProductDto;
import com.ultims.productmgt.comandservice.product.entity.Product;
import com.ultims.productmgt.comandservice.product.mapper.ProductMapper;
import com.ultims.productmgt.comandservice.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto add(CreateProductDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Invalid Product");
        }

        Product product = productMapper.toProduct(dto);
        Product addedProduct = productRepository.save(product);

        return productMapper.toDto(addedProduct);
    }

    @Override
    public ProductDto update(UUID id, UpdateProductDto dto) {
        if (id == null) {
            throw new IllegalArgumentException("ID can not be null");
        }

        if (dto == null) {
            throw new IllegalArgumentException("Invalid Product");
        }

        Product product = productMapper.toProduct(dto, id);
        Product updatedProduct = productRepository.save(product);

        return productMapper.toDto(updatedProduct);
    }
}
