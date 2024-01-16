package com.magnetron.billing.infraestructure.adapters.mappers;

import com.magnetron.billing.application.controllers.dtos.ViewPersonBuysMoreExpensiveProductDTO;
import com.magnetron.billing.domain.entities.ViewPersonBuysMoreExpensiveProductEntity;
import com.magnetron.billing.infrastructure.adapters.mappers.ViewPersonBuysMoreExpensiveProductMapper;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ViewPersonBuysMoreExpensiveProductMapperTest {

    private ViewPersonBuysMoreExpensiveProductMapper mapper;

    @Before
    public void setUp() {
        ModelMapper modelMapper = new ModelMapper();
        this.mapper = new ViewPersonBuysMoreExpensiveProductMapper(modelMapper);
    }

    @Test
    public void testToDTO() {
        // Arrange
        ViewPersonBuysMoreExpensiveProductEntity entity = new ViewPersonBuysMoreExpensiveProductEntity();
        entity.setProductId(1L);
        entity.setName("Test Person");
        entity.setLastName("Test Product");

        // Act
        ViewPersonBuysMoreExpensiveProductDTO dto = mapper.toDTO(entity);

        // Assert
        assertNotNull(dto);
        assertEquals(entity.getProductId(), dto.getProductId());
        assertEquals(entity.getName(), dto.getName());
        assertEquals(entity.getLastName(), dto.getLastName());
    }

    @Test
    public void testToDTOList() {
        // Arrange
        ViewPersonBuysMoreExpensiveProductEntity entity1 = new ViewPersonBuysMoreExpensiveProductEntity();
        entity1.setProductId(1L);
        entity1.setName("Test Person");
        entity1.setLastName("Test Product");
        ViewPersonBuysMoreExpensiveProductEntity entity2 = new ViewPersonBuysMoreExpensiveProductEntity();
        entity2.setProductId(2L);
        entity2.setName("Test Person");
        entity2.setLastName("Test Product");
        ViewPersonBuysMoreExpensiveProductEntity entity3 = new ViewPersonBuysMoreExpensiveProductEntity();
        entity3.setProductId(3L);
        entity3.setName("Test Person");
        entity3.setLastName("Test Product");
        List<ViewPersonBuysMoreExpensiveProductEntity> entities = Arrays.asList(entity1, entity2, entity3);

        // Act
        List<ViewPersonBuysMoreExpensiveProductDTO> dtos = mapper.toDTOList(entities);

        // Assert
        assertNotNull(dtos);
        assertEquals(entities.size(), dtos.size());

        for (int i = 0; i < entities.size(); i++) {
            assertEquals(entities.get(i).getProductId(), dtos.get(i).getProductId());
            assertEquals(entities.get(i).getName(), dtos.get(i).getName());
            assertEquals(entities.get(i).getLastName(), dtos.get(i).getLastName());
        }
    }

}