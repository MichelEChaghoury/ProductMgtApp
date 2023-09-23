package com.ultims.productmgt.comandservice.product.controller.v1;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ultims.productmgt.comandservice.product.dto.CreateProductDto;
import com.ultims.productmgt.comandservice.product.dto.ProductDto;
import com.ultims.productmgt.comandservice.product.dto.UpdateProductDto;
import com.ultims.productmgt.comandservice.product.service.ProductService;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDto> add(@RequestBody CreateProductDto dto) {
        ProductDto productDto = productService.add(dto);
        return ResponseEntity.ok(productDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductDto> update(@PathVariable("id") UUID id, @RequestBody UpdateProductDto dto) {
        ProductDto productDto = productService.update(id, dto);
        return ResponseEntity.ok(productDto);
    }
}
