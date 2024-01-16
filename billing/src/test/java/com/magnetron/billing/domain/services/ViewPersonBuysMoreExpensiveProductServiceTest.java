package com.magnetron.billing.domain.services;

import com.magnetron.billing.application.controllers.dtos.ViewPersonBuysMoreExpensiveProductDTO;
import com.magnetron.billing.domain.entities.ViewPersonBuysMoreExpensiveProductEntity;
import com.magnetron.billing.infrastructure.adapters.mappers.ViewPersonBuysMoreExpensiveProductMapper;
import com.magnetron.billing.infrastructure.adapters.repositories.ViewPersonBuysMoreExpensiveProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ViewPersonBuysMoreExpensiveProductServiceTest {

    @Mock
    private ViewPersonBuysMoreExpensiveProductRepository repository;

    @Mock
    private ViewPersonBuysMoreExpensiveProductMapper mapper;

    @InjectMocks
    private ViewPersonBuysMoreExpensiveProductService service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        // Arrange
        List<ViewPersonBuysMoreExpensiveProductEntity> entities = Arrays.asList(new ViewPersonBuysMoreExpensiveProductEntity(), new ViewPersonBuysMoreExpensiveProductEntity());
        List<ViewPersonBuysMoreExpensiveProductDTO> dtos = Arrays.asList(new ViewPersonBuysMoreExpensiveProductDTO(), new ViewPersonBuysMoreExpensiveProductDTO());

        when(repository.findAll()).thenReturn(entities);
        when(mapper.toDTOList(entities)).thenReturn(dtos);

        // Act
        List<ViewPersonBuysMoreExpensiveProductDTO> result = service.getAll();

        // Assert
        assertEquals(dtos.size(), result.size());

        // Verifica que repository.findAll se llamó
        verify(repository, times(1)).findAll();

        // Verifica que mapper.toDTOList se llamó con las entidades correctas
        verify(mapper, times(1)).toDTOList(eq(entities));
    }

}