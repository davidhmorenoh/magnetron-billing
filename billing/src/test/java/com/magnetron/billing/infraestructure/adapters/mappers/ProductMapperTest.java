package com.magnetron.billing.infraestructure.adapters.mappers;

import com.magnetron.billing.application.controllers.dtos.ProductDTO;
import com.magnetron.billing.domain.entities.ProductEntity;
import com.magnetron.billing.infrastructure.adapters.mappers.ProductMapper;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProductMapperTest {

    private ProductMapper productMapper;

    @Before
    public void setUp() {
        ModelMapper modelMapper = new ModelMapper();
        this.productMapper = new ProductMapper(modelMapper);
    }

    @Test
    public void testToDTO() {
        // Arrange
        ProductEntity entity = new ProductEntity();
        entity.setId(1L);
        entity.setDescription("Test Description");
        // Set other fields as needed...

        // Act
        ProductDTO dto = productMapper.toDTO(entity);

        // Assert
        assertNotNull(dto);
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getDescription(), dto.getDescription());
        // Add assertions for other fields...
    }

    @Test
    public void testToEntity() {
        // Arrange
        ProductDTO dto = new ProductDTO();
        dto.setId(1L);
        dto.setDescription("Test Description");
        // Set other fields as needed...

        // Act
        ProductEntity entity = productMapper.toEntity(dto);

        // Assert
        assertNotNull(entity);
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getDescription(), entity.getDescription());
        // Add assertions for other fields...
    }

    @Test
    public void testToDTOList() {
        // Arrange
        ProductEntity entity1 = new ProductEntity();
        entity1.setId(1L);
        entity1.setDescription("Test Description");
        ProductEntity entity2 = new ProductEntity();
        entity2.setId(2L);
        entity2.setDescription("Test Description");
        ProductEntity entity3 = new ProductEntity();
        entity3.setId(3L);
        entity3.setDescription("Test Description");
        List<ProductEntity> entities = Arrays.asList(entity1, entity2, entity3);

        // Act
        List<ProductDTO> dtos = productMapper.toDTOList(entities);

        // Assert
        assertNotNull(dtos);
        assertEquals(entities.size(), dtos.size());

        for (int i = 0; i < entities.size(); i++) {
            assertEquals(entities.get(i).getId(), dtos.get(i).getId());
            assertEquals(entities.get(i).getDescription(), dtos.get(i).getDescription());
            // Add assertions for other fields...
        }
    }

}