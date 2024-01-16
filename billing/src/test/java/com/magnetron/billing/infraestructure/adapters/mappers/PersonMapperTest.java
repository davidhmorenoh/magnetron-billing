package com.magnetron.billing.infraestructure.adapters.mappers;

import com.magnetron.billing.application.controllers.dtos.PersonDTO;
import com.magnetron.billing.domain.entities.PersonEntity;
import com.magnetron.billing.infrastructure.adapters.mappers.PersonMapper;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PersonMapperTest {

    private PersonMapper personMapper;

    @Before
    public void setUp() {
        ModelMapper modelMapper = new ModelMapper();
        this.personMapper = new PersonMapper(modelMapper);
    }

    @Test
    public void testToDTO() {
        // Arrange
        PersonEntity entity = new PersonEntity();
        entity.setId(1L);
        entity.setName("Test Name");
        // Set other fields as needed...

        // Act
        PersonDTO dto = personMapper.toDTO(entity);

        // Assert
        assertNotNull(dto);
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getName(), dto.getName());
        // Add assertions for other fields...
    }

    @Test
    public void testToEntity() {
        // Arrange
        PersonDTO dto = new PersonDTO();
        dto.setId(1L);
        dto.setName("Test Name");
        // Set other fields as needed...

        // Act
        PersonEntity entity = personMapper.toEntity(dto);

        // Assert
        assertNotNull(entity);
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getName(), entity.getName());
        // Add assertions for other fields...
    }

    @Test
    public void testToDTOList() {
        // Arrange
        PersonEntity entity1 = new PersonEntity();
        entity1.setId(1L);
        entity1.setName("Test Name");
        PersonEntity entity2 = new PersonEntity();
        entity2.setId(2L);
        entity2.setName("Test Name");
        PersonEntity entity3 = new PersonEntity();
        entity3.setId(3L);
        entity3.setName("Test Name");
        List<PersonEntity> entities = Arrays.asList(entity1, entity2, entity3);

        // Act
        List<PersonDTO> dtos = personMapper.toDTOList(entities);

        // Assert
        assertNotNull(dtos);
        assertEquals(entities.size(), dtos.size());

        for (int i = 0; i < entities.size(); i++) {
            assertEquals(entities.get(i).getId(), dtos.get(i).getId());
            assertEquals(entities.get(i).getName(), dtos.get(i).getName());
            // Add assertions for other fields...
        }
    }

}