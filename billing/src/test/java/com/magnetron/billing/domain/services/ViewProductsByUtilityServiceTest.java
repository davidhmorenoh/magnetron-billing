package com.magnetron.billing.domain.services;

import com.magnetron.billing.application.controllers.dtos.ViewProductsByUtilityDTO;
import com.magnetron.billing.domain.entities.ViewProductsByUtilityEntity;
import com.magnetron.billing.infrastructure.adapters.mappers.ViewProductsByUtilityMapper;
import com.magnetron.billing.infrastructure.adapters.repositories.ViewProductsByUtilityRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ViewProductsByUtilityServiceTest {

    @Mock
    private ViewProductsByUtilityRepository repository;

    @Mock
    private ViewProductsByUtilityMapper mapper;

    @InjectMocks
    private ViewProductsByUtilityService service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        // Arrange
        List<ViewProductsByUtilityEntity> entities = Arrays.asList(new ViewProductsByUtilityEntity(), new ViewProductsByUtilityEntity());
        List<ViewProductsByUtilityDTO> dtos = Arrays.asList(new ViewProductsByUtilityDTO(), new ViewProductsByUtilityDTO());

        when(repository.findAll()).thenReturn(entities);
        when(mapper.toDTOList(entities)).thenReturn(dtos);

        // Act
        List<ViewProductsByUtilityDTO> result = service.getAll();

        // Assert
        assertEquals(dtos.size(), result.size());

        // Verifica que repository.findAll se llamó
        verify(repository, times(1)).findAll();

        // Verifica que mapper.toDTOList se llamó con las entidades correctas
        verify(mapper, times(1)).toDTOList(eq(entities));
    }

}