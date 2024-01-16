package com.magnetron.billing.infraestructure.adapters.mappers;

import com.magnetron.billing.application.controllers.dtos.ViewProductsWithProfitMarginDTO;
import com.magnetron.billing.domain.entities.ViewProductsWithProfitMarginEntity;
import com.magnetron.billing.infrastructure.adapters.mappers.ViewProductsWithProfitMarginMapper;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ViewProductsWithProfitMarginMapperTest {

    private ViewProductsWithProfitMarginMapper mapper;

    @Before
    public void setUp() {
        ModelMapper modelMapper = new ModelMapper();
        this.mapper = new ViewProductsWithProfitMarginMapper(modelMapper);
    }

    @Test
    public void testToDTO() {
        // Arrange
        ViewProductsWithProfitMarginEntity entity = new ViewProductsWithProfitMarginEntity();
        entity.setProductId(1L);
        entity.setDescription("Test Product");

        // Act
        ViewProductsWithProfitMarginDTO dto = mapper.toDTO(entity);

        // Assert
        assertNotNull(dto);
        assertEquals(entity.getProductId(), dto.getProductId());
        assertEquals(entity.getDescription(), dto.getDescription());
    }

    @Test
    public void testToDTOList() {
        // Arrange
        ViewProductsWithProfitMarginEntity entity1 = new ViewProductsWithProfitMarginEntity();
        entity1.setProductId(1L);
        entity1.setDescription("Test Product");
        ViewProductsWithProfitMarginEntity entity2 = new ViewProductsWithProfitMarginEntity();
        entity2.setProductId(2L);
        entity2.setDescription("Test Product");
        ViewProductsWithProfitMarginEntity entity3 = new ViewProductsWithProfitMarginEntity();
        entity3.setProductId(3L);
        entity3.setDescription("Test Product");
        List<ViewProductsWithProfitMarginEntity> entities = Arrays.asList(entity1, entity2, entity3);

        // Act
        List<ViewProductsWithProfitMarginDTO> dtos = mapper.toDTOList(entities);

        // Assert
        assertNotNull(dtos);
        assertEquals(entities.size(), dtos.size());

        for (int i = 0; i < entities.size(); i++) {
            assertEquals(entities.get(i).getProductId(), dtos.get(i).getProductId());
            assertEquals(entities.get(i).getDescription(), dtos.get(i).getDescription());
        }
    }

}