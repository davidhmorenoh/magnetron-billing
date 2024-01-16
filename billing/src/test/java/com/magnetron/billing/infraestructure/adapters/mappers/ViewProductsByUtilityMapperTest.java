package com.magnetron.billing.infraestructure.adapters.mappers;

import com.magnetron.billing.application.controllers.dtos.ViewProductsByUtilityDTO;
import com.magnetron.billing.domain.entities.ViewProductsByUtilityEntity;
import com.magnetron.billing.infrastructure.adapters.mappers.ViewProductsByUtilityMapper;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ViewProductsByUtilityMapperTest {

    private ViewProductsByUtilityMapper mapper;

    @Before
    public void setUp() {
        ModelMapper modelMapper = new ModelMapper();
        this.mapper = new ViewProductsByUtilityMapper(modelMapper);
    }

    @Test
    public void testToDTO() {
        // Arrange
        ViewProductsByUtilityEntity entity = new ViewProductsByUtilityEntity();
        entity.setProductId(1L);
        entity.setDescription("Test Product");

        // Act
        ViewProductsByUtilityDTO dto = mapper.toDTO(entity);

        // Assert
        assertNotNull(dto);
        assertEquals(entity.getProductId(), dto.getProductId());
        assertEquals(entity.getDescription(), dto.getDescription());
    }

    @Test
    public void testToDTOList() {
        // Arrange
        ViewProductsByUtilityEntity entity1 = new ViewProductsByUtilityEntity();
        entity1.setProductId(1L);
        entity1.setDescription("Test Product");
        ViewProductsByUtilityEntity entity2 = new ViewProductsByUtilityEntity();
        entity2.setProductId(1L);
        entity2.setDescription("Test Product");
        ViewProductsByUtilityEntity entity3 = new ViewProductsByUtilityEntity();
        entity3.setProductId(1L);
        entity3.setDescription("Test Product");
        List<ViewProductsByUtilityEntity> entities = Arrays.asList(entity1, entity2, entity3);

        // Act
        List<ViewProductsByUtilityDTO> dtos = mapper.toDTOList(entities);

        // Assert
        assertNotNull(dtos);
        assertEquals(entities.size(), dtos.size());

        for (int i = 0; i < entities.size(); i++) {
            assertEquals(entities.get(i).getProductId(), dtos.get(i).getProductId());
            assertEquals(entities.get(i).getDescription(), dtos.get(i).getDescription());
        }
    }

}