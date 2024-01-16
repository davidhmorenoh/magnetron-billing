package com.magnetron.billing.domain.services;

import com.magnetron.billing.application.controllers.dtos.ViewProductsByInvoicedQuantityDTO;
import com.magnetron.billing.domain.entities.ViewProductsByInvoicedQuantityEntity;
import com.magnetron.billing.infrastructure.adapters.mappers.ViewProductsByInvoicedQuantityMapper;
import com.magnetron.billing.infrastructure.adapters.repositories.ViewProductsByInvoicedQuantityRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ViewProductsByInvoicedQuantityServiceTest {

    @Mock
    private ViewProductsByInvoicedQuantityRepository repository;

    @Mock
    private ViewProductsByInvoicedQuantityMapper mapper;

    @InjectMocks
    private ViewProductsByInvoicedQuantityService service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        // Arrange
        List<ViewProductsByInvoicedQuantityEntity> entities = Arrays.asList(new ViewProductsByInvoicedQuantityEntity(), new ViewProductsByInvoicedQuantityEntity());
        List<ViewProductsByInvoicedQuantityDTO> dtos = Arrays.asList(new ViewProductsByInvoicedQuantityDTO(), new ViewProductsByInvoicedQuantityDTO());

        when(repository.findAll()).thenReturn(entities);
        when(mapper.toDTOList(entities)).thenReturn(dtos);

        // Act
        List<ViewProductsByInvoicedQuantityDTO> result = service.getAll();

        // Assert
        assertEquals(dtos.size(), result.size());

        // Verifica que repository.findAll se llamó
        verify(repository, times(1)).findAll();

        // Verifica que mapper.toDTOList se llamó con las entidades correctas
        verify(mapper, times(1)).toDTOList(eq(entities));
    }

}