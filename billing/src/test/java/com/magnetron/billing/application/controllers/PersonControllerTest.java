package com.magnetron.billing.application.controllers;

import com.magnetron.billing.application.controllers.dtos.PersonDTO;
import com.magnetron.billing.domain.services.PersonService;
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

public class PersonControllerTest {

    @Mock
    private PersonService personService;

    @InjectMocks
    private PersonController personController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllPeople() {
        // Arrange
        List<PersonDTO> mockPersonList = new ArrayList<>();
        when(personService.getAllPeople()).thenReturn(mockPersonList);

        // Act
        ResponseEntity<List<PersonDTO>> response = personController.getAllPeople();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockPersonList, response.getBody());
    }

    @Test
    public void testGetPersonByIdFound() {
        // Arrange
        Long personId = 1L;
        PersonDTO mockPerson = new PersonDTO();
        when(personService.getPersonById(personId)).thenReturn(Optional.of(mockPerson));

        // Act
        ResponseEntity<PersonDTO> response = personController.getPersonById(personId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockPerson, response.getBody());
    }

    @Test
    public void testGetPersonByIdNotFound() {
        // Arrange
        Long personId = 1L;
        when(personService.getPersonById(personId)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<PersonDTO> response = personController.getPersonById(personId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testCreatePerson() {
        // Arrange
        PersonDTO inputPerson = new PersonDTO();
        PersonDTO createdPerson = new PersonDTO();
        when(personService.createPerson(inputPerson)).thenReturn(createdPerson);

        // Act
        ResponseEntity<PersonDTO> response = personController.createPerson(inputPerson);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdPerson, response.getBody());
    }

    @Test
    public void testUpdatePersonFound() {
        // Arrange
        Long personId = 1L;
        PersonDTO updatedPersonDTO = new PersonDTO();
        when(personService.updatePerson(personId, updatedPersonDTO)).thenReturn(Optional.of(updatedPersonDTO));

        // Act
        ResponseEntity<PersonDTO> response = personController.updatePerson(personId, updatedPersonDTO);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedPersonDTO, response.getBody());
    }

    @Test
    public void testUpdatePersonNotFound() {
        // Arrange
        Long personId = 1L;
        PersonDTO updatedPersonDTO = new PersonDTO();
        when(personService.updatePerson(personId, updatedPersonDTO)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<PersonDTO> response = personController.updatePerson(personId, updatedPersonDTO);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testDeletePerson() {
        // Arrange
        Long personId = 1L;

        // Act
        ResponseEntity<Void> response = personController.deletePerson(personId);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(personService, times(1)).deletePerson(personId);
    }

}