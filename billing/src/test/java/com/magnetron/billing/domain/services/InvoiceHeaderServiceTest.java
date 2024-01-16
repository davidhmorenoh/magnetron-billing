package com.magnetron.billing.domain.services;

import com.magnetron.billing.domain.entities.InvoiceHeaderEntity;
import com.magnetron.billing.infrastructure.adapters.repositories.InvoiceHeaderRepository;
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

public class InvoiceHeaderServiceTest {

    @Mock
    private InvoiceHeaderRepository invoiceHeaderRepository;

    @InjectMocks
    private InvoiceHeaderService invoiceHeaderService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllInvoiceHeaderEntities() {
        // Arrange
        List<InvoiceHeaderEntity> mockList = new ArrayList<>();
        when(invoiceHeaderRepository.findAll()).thenReturn(mockList);

        // Act
        List<InvoiceHeaderEntity> result = invoiceHeaderService.getAllInvoiceHeaderEntities();

        // Assert
        assertEquals(mockList, result);
    }

    @Test
    public void testGetInvoiceHeaderByIdFound() {
        // Arrange
        Long id = 1L;
        InvoiceHeaderEntity mockEntity = new InvoiceHeaderEntity();
        when(invoiceHeaderRepository.findById(id)).thenReturn(Optional.of(mockEntity));

        // Act
        Optional<InvoiceHeaderEntity> result = invoiceHeaderService.getInvoiceHeaderById(id);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(mockEntity, result.get());
    }

    @Test
    public void testGetInvoiceHeaderByIdNotFound() {
        // Arrange
        Long id = 1L;
        when(invoiceHeaderRepository.findById(id)).thenReturn(Optional.empty());

        // Act
        Optional<InvoiceHeaderEntity> result = invoiceHeaderService.getInvoiceHeaderById(id);

        // Assert
        assertFalse(result.isPresent());
    }

    @Test
    public void testCreateInvoiceHeader() {
        // Arrange
        InvoiceHeaderEntity inputEntity = new InvoiceHeaderEntity();
        InvoiceHeaderEntity createdEntity = new InvoiceHeaderEntity();
        when(invoiceHeaderRepository.save(inputEntity)).thenReturn(createdEntity);

        // Act
        InvoiceHeaderEntity result = invoiceHeaderService.createInvoiceHeader(inputEntity);

        // Assert
        assertEquals(createdEntity, result);
    }

    @Test
    public void testUpdateInvoiceHeaderFound() {
        // Arrange
        Long id = 1L;
        InvoiceHeaderEntity updatedEntity = new InvoiceHeaderEntity();
        when(invoiceHeaderRepository.existsById(id)).thenReturn(true);
        when(invoiceHeaderRepository.save(updatedEntity)).thenReturn(updatedEntity);

        // Act
        InvoiceHeaderEntity result = invoiceHeaderService.updateInvoiceHeader(id, updatedEntity);

        // Assert
        assertEquals(updatedEntity, result);
    }

    @Test
    public void testUpdateInvoiceHeaderNotFound() {
        // Arrange
        Long id = 1L;
        InvoiceHeaderEntity updatedEntity = new InvoiceHeaderEntity();
        when(invoiceHeaderRepository.existsById(id)).thenReturn(false);

        // Act
        InvoiceHeaderEntity result = invoiceHeaderService.updateInvoiceHeader(id, updatedEntity);

        // Assert
        assertNull(result);
    }

    @Test
    public void testDeleteInvoiceHeader() {
        // Arrange
        Long id = 1L;

        // Act
        invoiceHeaderService.deleteInvoiceHeader(id);

        // Assert
        verify(invoiceHeaderRepository, times(1)).deleteById(id);
    }

}