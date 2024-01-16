package com.magnetron.billing.domain.services;

import com.magnetron.billing.application.controllers.dtos.PersonDTO;
import com.magnetron.billing.domain.entities.PersonEntity;
import com.magnetron.billing.infrastructure.adapters.mappers.PersonMapper;
import com.magnetron.billing.infrastructure.adapters.repositories.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService personService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllPeople() {
        // Arrange
        List<PersonEntity> mockEntityList = new ArrayList<>();
        List<PersonDTO> mockDTOList = new ArrayList<>();
        when(personRepository.findAll()).thenReturn(mockEntityList);
        when(personMapper.toDTOList(mockEntityList)).thenReturn(mockDTOList);

        // Act
        List<PersonDTO> result = personService.getAllPeople();

        // Assert
        assertEquals(mockDTOList, result);
    }

    @Test
    public void testGetPersonByIdFound() {
        // Arrange
        Long id = 1L;
        PersonEntity mockEntity = new PersonEntity();
        PersonDTO mockDTO = new PersonDTO();
        when(personRepository.findById(id)).thenReturn(Optional.of(mockEntity));
        when(personMapper.toDTO(mockEntity)).thenReturn(mockDTO);

        // Act
        Optional<PersonDTO> result = personService.getPersonById(id);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(mockDTO, result.get());
    }

    @Test
    public void testGetPersonByIdNotFound() {
        // Arrange
        Long id = 1L;
        when(personRepository.findById(id)).thenReturn(Optional.empty());

        // Act
        Optional<PersonDTO> result = personService.getPersonById(id);

        // Assert
        assertFalse(result.isPresent());
    }

    @Test
    public void testCreatePerson() {
        // Arrange
        PersonDTO inputDTO = new PersonDTO();
        PersonEntity createdEntity = new PersonEntity();
        when(personMapper.toEntity(inputDTO)).thenReturn(createdEntity);
        when(personRepository.save(createdEntity)).thenReturn(createdEntity);
        when(personMapper.toDTO(createdEntity)).thenReturn(inputDTO);

        // Act
        PersonDTO result = personService.createPerson(inputDTO);

        // Assert
        assertEquals(inputDTO, result);
    }

    @Test
    public void testUpdatePersonFound() {
        // Arrange
        Long id = 1L;
        PersonDTO inputDTO = new PersonDTO();
        PersonEntity updatedEntity = new PersonEntity();

        when(personRepository.findById(id)).thenReturn(Optional.of(updatedEntity));
        when(personRepository.save(any())).thenReturn(updatedEntity);
        when(personMapper.toDTO(updatedEntity)).thenReturn(inputDTO);

        // Act
        Optional<PersonDTO> result = personService.updatePerson(id, inputDTO);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(inputDTO, result.get());

        // Verifica que personRepository.findById se llamó con el ID correcto
        verify(personRepository, times(1)).findById(eq(id));

        // Verifica que personRepository.save se llamó con la entidad actualizada
        verify(personRepository, times(1)).save(same(updatedEntity));
    }

    @Test
    public void testUpdatePersonNotFound() {
        // Arrange
        Long id = 1L;
        PersonDTO inputDTO = new PersonDTO();
        when(personRepository.findById(id)).thenReturn(Optional.empty());

        // Act
        Optional<PersonDTO> result = personService.updatePerson(id, inputDTO);

        // Assert
        assertFalse(result.isPresent());
    }

    @Test
    public void testDeletePerson() {
        // Arrange
        Long id = 1L;

        // Act
        personService.deletePerson(id);

        // Assert
        verify(personRepository, times(1)).deleteById(id);
    }

}