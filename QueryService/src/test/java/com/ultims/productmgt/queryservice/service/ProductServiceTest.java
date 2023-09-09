package com.ultims.productmgt.queryservice.service;

import com.ultims.productmgt.queryservice.dto.ProductDto;
import com.ultims.productmgt.queryservice.entity.Product;
import com.ultims.productmgt.queryservice.mapper.ProductMapper;
import com.ultims.productmgt.queryservice.mapper.ProductMapperImpl;
import com.ultims.productmgt.queryservice.repository.ProductRepository;
import com.ultims.productmgt.queryservice.shared.exception.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    private ProductService underTest;

    @Mock
    private ProductRepository productRepositoryStub;
    private final ProductMapper productMapper = new ProductMapperImpl();

    @BeforeEach
    void setUp() {
        underTest = new ProductServiceImpl(productRepositoryStub, productMapper);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenGivenIdIsNull() {
        // Given
        UUID productId = null;
        String message = "Invalid Input. Product ID can not be null";

        // When
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> underTest.get(productId));

        // Then
        assertThat(exception.getMessage()).isEqualTo(message);
    }

    @Test
    void shouldReturnNotFoundExceptionWhenNoProductWithGivenIdWasFound() {
        // Given
        UUID productId = UUID.randomUUID();
        String message = "No Product with ID: " + productId + " was found";

        // When
        NotFoundException exception = assertThrows(NotFoundException.class, () -> underTest.get(productId));

        // Then
        assertThat(exception.getMessage()).isEqualTo(message);
    }

    @Test
    void shouldReturnProductFoundWithGivenId() {
        // Given
        UUID productId = UUID.randomUUID();
        Product product = Product.builder()
                .id(productId)
                .build();

        Mockito
                .when(productRepositoryStub.findById(productId))
                .thenReturn(Optional.of(product));

        // When
        ProductDto actual = underTest.get(productId);
        ProductDto expected = productMapper.toDto(product);

        // Then
        assertThat(actual).isEqualTo(expected);
    }
}
