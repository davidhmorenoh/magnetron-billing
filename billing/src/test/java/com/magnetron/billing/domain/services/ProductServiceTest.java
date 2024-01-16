package com.magnetron.billing.domain.services;

import com.magnetron.billing.application.controllers.dtos.ProductDTO;
import com.magnetron.billing.domain.entities.ProductEntity;
import com.magnetron.billing.infrastructure.adapters.mappers.ProductMapper;
import com.magnetron.billing.infrastructure.adapters.repositories.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductService productService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllProducts() {
        // Arrange
        List<ProductEntity> productList = new ArrayList<>();
        List<ProductDTO> mockDTOList = new ArrayList<>();
        when(productRepository.findAll()).thenReturn(productList);
        when(productMapper.toDTOList(productList)).thenReturn(mockDTOList);

        // Act
        List<ProductDTO> result = productService.getAllProducts();

        // Assert
        assertNotNull(result);
        assertEquals(productList, result);
    }

    @Test
    public void testGetProductByIdFound() {
        // Arrange
        Long id = 1L;
        ProductDTO productDTO = new ProductDTO();
        when(productRepository.findById(id)).thenReturn(Optional.of(new ProductEntity()));
        when(productMapper.toDTO(any())).thenReturn(productDTO);

        // Act
        Optional<ProductDTO> result = productService.getProductById(id);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(productDTO, result.get());
    }

    @Test
    public void testGetProductByIdNotFound() {
        // Arrange
        Long id = 1L;
        when(productRepository.findById(id)).thenReturn(Optional.empty());

        // Act
        Optional<ProductDTO> result = productService.getProductById(id);

        // Assert
        assertFalse(result.isPresent());
    }

    @Test
    public void testCreateProduct() {
        // Arrange
        ProductDTO inputDTO = new ProductDTO();
        ProductEntity productEntity = new ProductEntity();
        when(productMapper.toEntity(inputDTO)).thenReturn(productEntity);
        when(productRepository.save(productEntity)).thenReturn(productEntity);
        when(productMapper.toDTO(productEntity)).thenReturn(inputDTO);

        // Act
        ProductDTO result = productService.createProduct(inputDTO);

        // Assert
        assertNotNull(result);
        assertEquals(inputDTO, result);

        // Verifica que productRepository.save se llamó con la entidad correcta
        verify(productRepository, times(1)).save(eq(productEntity));
    }

    @Test
    public void testUpdateProductFound() {
        // Arrange
        Long id = 1L;
        ProductDTO updatedDTO = new ProductDTO();
        ProductEntity existingEntity = new ProductEntity();
        when(productRepository.findById(id)).thenReturn(Optional.of(existingEntity));
        when(productRepository.save(any())).thenReturn(existingEntity);  // Simula la operación de guardado
        when(productMapper.toDTO(existingEntity)).thenReturn(updatedDTO);

        // Act
        Optional<ProductDTO> result = productService.updateProduct(id, updatedDTO);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(updatedDTO, result.get());

        // Verifica que productRepository.findById se llamó con el ID correcto
        verify(productRepository, times(1)).findById(eq(id));

        // Verifica que productRepository.save se llamó con la entidad actualizada
        verify(productRepository, times(1)).save(same(existingEntity));
    }

    @Test
    public void testUpdateProductNotFound() {
        // Arrange
        Long id = 1L;
        ProductDTO updatedDTO = new ProductDTO();
        when(productRepository.findById(id)).thenReturn(Optional.empty());

        // Act
        Optional<ProductDTO> result = productService.updateProduct(id, updatedDTO);

        // Assert
        assertFalse(result.isPresent());
    }

    @Test
    public void testDeleteProduct() {
        // Arrange
        Long id = 1L;

        // Act
        productService.deleteProduct(id);

        // Assert
        // Verifica que productRepository.deleteById se llamó con el ID correcto
        verify(productRepository, times(1)).deleteById(eq(id));
    }

}