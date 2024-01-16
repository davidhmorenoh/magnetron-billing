package com.magnetron.billing.domain.services;

import com.magnetron.billing.application.controllers.dtos.ViewTotalBilledPerPersonDTO;
import com.magnetron.billing.domain.entities.ViewTotalBilledPerPersonEntity;
import com.magnetron.billing.infrastructure.adapters.mappers.ViewTotalBilledPerPersonMapper;
import com.magnetron.billing.infrastructure.adapters.repositories.ViewTotalBilledPerPersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ViewTotalBilledPerPersonServiceTest {

    @Mock
    private ViewTotalBilledPerPersonRepository repository;

    @Mock
    private ViewTotalBilledPerPersonMapper mapper;

    @InjectMocks
    private ViewTotalBilledPerPersonService service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        // Arrange
        List<ViewTotalBilledPerPersonEntity> entities = Arrays.asList(new ViewTotalBilledPerPersonEntity(), new ViewTotalBilledPerPersonEntity());
        List<ViewTotalBilledPerPersonDTO> dtos = Arrays.asList(new ViewTotalBilledPerPersonDTO(), new ViewTotalBilledPerPersonDTO());

        when(repository.findAll()).thenReturn(entities);
        when(mapper.toDTOList(entities)).thenReturn(dtos);

        // Act
        List<ViewTotalBilledPerPersonDTO> result = service.getAll();

        // Assert
        assertEquals(dtos.size(), result.size());

        // Verifica que repository.findAll se llamó
        verify(repository, times(1)).findAll();

        // Verifica que mapper.toDTOList se llamó con las entidades correctas
        verify(mapper, times(1)).toDTOList(eq(entities));
    }

}