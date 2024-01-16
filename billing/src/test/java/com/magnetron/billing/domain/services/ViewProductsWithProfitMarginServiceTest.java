package com.magnetron.billing.domain.services;

import com.magnetron.billing.application.controllers.dtos.ViewProductsWithProfitMarginDTO;
import com.magnetron.billing.domain.entities.ViewProductsWithProfitMarginEntity;
import com.magnetron.billing.infrastructure.adapters.mappers.ViewProductsWithProfitMarginMapper;
import com.magnetron.billing.infrastructure.adapters.repositories.ViewProductsWithProfitMarginRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ViewProductsWithProfitMarginServiceTest {

    @Mock
    private ViewProductsWithProfitMarginRepository repository;

    @Mock
    private ViewProductsWithProfitMarginMapper mapper;

    @InjectMocks
    private ViewProductsWithProfitMarginService service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        // Arrange
        List<ViewProductsWithProfitMarginEntity> entities = Arrays.asList(new ViewProductsWithProfitMarginEntity(), new ViewProductsWithProfitMarginEntity());
        List<ViewProductsWithProfitMarginDTO> dtos = Arrays.asList(new ViewProductsWithProfitMarginDTO(), new ViewProductsWithProfitMarginDTO());

        when(repository.findAll()).thenReturn(entities);
        when(mapper.toDTOList(entities)).thenReturn(dtos);

        // Act
        List<ViewProductsWithProfitMarginDTO> result = service.getAll();

        // Assert
        assertEquals(dtos.size(), result.size());

        // Verifica que repository.findAll se llamó
        verify(repository, times(1)).findAll();

        // Verifica que mapper.toDTOList se llamó con las entidades correctas
        verify(mapper, times(1)).toDTOList(eq(entities));
    }

}