package com.magnetron.billing.application.controllers;

import com.magnetron.billing.application.controllers.dtos.ProductDTO;
import com.magnetron.billing.domain.services.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllProducts() {
        // Arrange
        List<ProductDTO> mockProductList = new ArrayList<>();
        when(productService.getAllProducts()).thenReturn(mockProductList);

        // Act
        ResponseEntity<List<ProductDTO>> response = productController.getAllProducts();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockProductList, response.getBody());
    }

    @Test
    public void testGetProductByIdFound() {
        // Arrange
        Long productId = 1L;
        ProductDTO mockProduct = new ProductDTO();
        when(productService.getProductById(productId)).thenReturn(Optional.of(mockProduct));

        // Act
        ResponseEntity<ProductDTO> response = productController.getProductById(productId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockProduct, response.getBody());
    }

    @Test
    public void testGetProductByIdNotFound() {
        // Arrange
        Long productId = 1L;
        when(productService.getProductById(productId)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<ProductDTO> response = productController.getProductById(productId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testCreateProduct() {
        // Arrange
        ProductDTO inputProduct = new ProductDTO();
        ProductDTO createdProduct = new ProductDTO();
        when(productService.createProduct(inputProduct)).thenReturn(createdProduct);

        // Act
        ResponseEntity<ProductDTO> response = productController.createProduct(inputProduct);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdProduct, response.getBody());
    }

    @Test
    public void testUpdateProductFound() {
        // Arrange
        Long productId = 1L;
        ProductDTO updatedProductDTO = new ProductDTO();
        when(productService.updateProduct(productId, updatedProductDTO)).thenReturn(Optional.of(updatedProductDTO));

        // Act
        ResponseEntity<ProductDTO> response = productController.updateProduct(productId, updatedProductDTO);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedProductDTO, response.getBody());
    }

    @Test
    public void testUpdateProductNotFound() {
        // Arrange
        Long productId = 1L;
        ProductDTO updatedProductDTO = new ProductDTO();
        when(productService.updateProduct(productId, updatedProductDTO)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<ProductDTO> response = productController.updateProduct(productId, updatedProductDTO);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testDeleteProduct() {
        // Arrange
        Long productId = 1L;

        // Act
        ResponseEntity<Void> response = productController.deleteProduct(productId);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(productService, times(1)).deleteProduct(productId);
    }

}