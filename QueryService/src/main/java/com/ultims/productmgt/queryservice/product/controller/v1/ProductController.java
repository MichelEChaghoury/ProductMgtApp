package com.ultims.productmgt.queryservice.product.controller.v1;

import java.util.List;
import java.util.UUID;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ultims.productmgt.queryservice.product.dto.ProductDto;
import com.ultims.productmgt.queryservice.product.route.v1.ProductRoute;
import com.ultims.productmgt.queryservice.product.segregate.query.GetProductByIdQuery;
import com.ultims.productmgt.queryservice.product.segregate.query.GetProductsQuery;

@RestController
public class ProductController {

    private final QueryGateway queryGateway;

    public ProductController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping(ProductRoute.GET_ALL)
    public ResponseEntity<List<ProductDto>> get() {
        GetProductsQuery query = new GetProductsQuery();
        List<ProductDto> productDtos = queryGateway
                .query(query, ResponseTypes.multipleInstancesOf(ProductDto.class))
                .join();

        return ResponseEntity.ok(productDtos);
    }

    @GetMapping(ProductRoute.GET_BY_ID)
    public ResponseEntity<ProductDto> get(@PathVariable("id") UUID id) {
        GetProductByIdQuery query = new GetProductByIdQuery(id);

        ProductDto productDto = queryGateway
                .query(query, ResponseTypes.instanceOf(ProductDto.class))
                .join();

        return ResponseEntity.ok(productDto);
    }
}
