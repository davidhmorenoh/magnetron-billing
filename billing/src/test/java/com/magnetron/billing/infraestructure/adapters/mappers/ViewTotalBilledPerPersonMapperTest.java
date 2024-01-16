package com.magnetron.billing.infraestructure.adapters.mappers;

import com.magnetron.billing.application.controllers.dtos.ViewTotalBilledPerPersonDTO;
import com.magnetron.billing.domain.entities.ViewTotalBilledPerPersonEntity;
import com.magnetron.billing.infrastructure.adapters.mappers.ViewTotalBilledPerPersonMapper;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ViewTotalBilledPerPersonMapperTest {

    private ViewTotalBilledPerPersonMapper mapper;

    @Before
    public void setUp() {
        ModelMapper modelMapper = new ModelMapper();
        this.mapper = new ViewTotalBilledPerPersonMapper(modelMapper);
    }

    @Test
    public void testToDTO() {
        // Arrange
        ViewTotalBilledPerPersonEntity entity = new ViewTotalBilledPerPersonEntity();
        entity.setId(1L);
        entity.setName("Test Person");

        // Act
        ViewTotalBilledPerPersonDTO dto = mapper.toDTO(entity);

        // Assert
        assertNotNull(dto);
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getName(), dto.getName());
    }

    @Test
    public void testToDTOList() {
        // Arrange
        ViewTotalBilledPerPersonEntity entity1 = new ViewTotalBilledPerPersonEntity();
        entity1.setId(1L);
        entity1.setName("Test Person");
        ViewTotalBilledPerPersonEntity entity2 = new ViewTotalBilledPerPersonEntity();
        entity2.setId(2L);
        entity2.setName("Test Person");
        ViewTotalBilledPerPersonEntity entity3 = new ViewTotalBilledPerPersonEntity();
        entity3.setId(3L);
        entity3.setName("Test Person");
        List<ViewTotalBilledPerPersonEntity> entities = Arrays.asList(entity1, entity2, entity3);

        // Act
        List<ViewTotalBilledPerPersonDTO> dtos = mapper.toDTOList(entities);

        // Assert
        assertNotNull(dtos);
        assertEquals(entities.size(), dtos.size());

        for (int i = 0; i < entities.size(); i++) {
            assertEquals(entities.get(i).getId(), dtos.get(i).getId());
            assertEquals(entities.get(i).getName(), dtos.get(i).getName());
        }
    }

}