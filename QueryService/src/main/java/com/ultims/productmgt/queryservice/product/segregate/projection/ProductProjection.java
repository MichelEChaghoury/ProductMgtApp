package com.ultims.productmgt.queryservice.product.segregate.projection;

import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import com.ultims.productmgt.queryservice.product.dto.ProductDto;
import com.ultims.productmgt.queryservice.product.segregate.query.GetProductsQuery;
import com.ultims.productmgt.queryservice.product.service.ProductService;

@Component
public class ProductProjection {

    private final ProductService productService;

    public ProductProjection(ProductService productService) {
        this.productService = productService;
    }

    @QueryHandler
    public List<ProductDto> handle(GetProductsQuery query) {
        return productService.get();
    }
}
