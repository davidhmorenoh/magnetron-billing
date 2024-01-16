package com.magnetron.billing.infraestructure.adapters.mappers;

import com.magnetron.billing.application.controllers.dtos.ViewProductsByInvoicedQuantityDTO;
import com.magnetron.billing.domain.entities.ViewProductsByInvoicedQuantityEntity;
import com.magnetron.billing.infrastructure.adapters.mappers.ViewProductsByInvoicedQuantityMapper;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ViewProductsByInvoicedQuantityMapperTest {

    private ViewProductsByInvoicedQuantityMapper mapper;

    @Before
    public void setUp() {
        ModelMapper modelMapper = new ModelMapper();
        this.mapper = new ViewProductsByInvoicedQuantityMapper(modelMapper);
    }

    @Test
    public void testToDTO() {
        // Arrange
        ViewProductsByInvoicedQuantityEntity entity = new ViewProductsByInvoicedQuantityEntity();
        entity.setId(1L);
        entity.setDescription("Test Product");

        // Act
        ViewProductsByInvoicedQuantityDTO dto = mapper.toDTO(entity);

        // Assert
        assertNotNull(dto);
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getDescription(), dto.getDescription());
    }

    @Test
    public void testToDTOList() {
        // Arrange
        ViewProductsByInvoicedQuantityEntity entity1 = new ViewProductsByInvoicedQuantityEntity();
        entity1.setId(1L);
        entity1.setDescription("Test Product");
        ViewProductsByInvoicedQuantityEntity entity2 = new ViewProductsByInvoicedQuantityEntity();
        entity2.setId(2L);
        entity2.setDescription("Test Product");
        ViewProductsByInvoicedQuantityEntity entity3 = new ViewProductsByInvoicedQuantityEntity();
        entity3.setId(3L);
        entity3.setDescription("Test Product");
        List<ViewProductsByInvoicedQuantityEntity> entities = Arrays.asList(entity1, entity2, entity3);

        // Act
        List<ViewProductsByInvoicedQuantityDTO> dtos = mapper.toDTOList(entities);

        // Assert
        assertNotNull(dtos);
        assertEquals(entities.size(), dtos.size());

        for (int i = 0; i < entities.size(); i++) {
            assertEquals(entities.get(i).getId(), dtos.get(i).getId());
            assertEquals(entities.get(i).getDescription(), dtos.get(i).getDescription());
        }
    }

}