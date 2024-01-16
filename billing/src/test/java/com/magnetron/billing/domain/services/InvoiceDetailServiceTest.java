package com.magnetron.billing.domain.services;

import com.magnetron.billing.domain.entities.InvoiceDetailEntity;
import com.magnetron.billing.infrastructure.adapters.repositories.InvoiceDetailRepository;
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

public class InvoiceDetailServiceTest {

    @Mock
    private InvoiceDetailRepository invoiceDetailRepository;

    @InjectMocks
    private InvoiceDetailService invoiceDetailService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllInvoiceDetailEntities() {
        // Arrange
        List<InvoiceDetailEntity> mockList = new ArrayList<>();
        when(invoiceDetailRepository.findAll()).thenReturn(mockList);

        // Act
        List<InvoiceDetailEntity> result = invoiceDetailService.getAllInvoiceDetailEntities();

        // Assert
        assertEquals(mockList, result);
    }

    @Test
    public void testGetInvoiceDetailByIdFound() {
        // Arrange
        Long id = 1L;
        InvoiceDetailEntity mockEntity = new InvoiceDetailEntity();
        when(invoiceDetailRepository.findById(id)).thenReturn(Optional.of(mockEntity));

        // Act
        Optional<InvoiceDetailEntity> result = invoiceDetailService.getInvoiceDetailById(id);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(mockEntity, result.get());
    }

    @Test
    public void testGetInvoiceDetailByIdNotFound() {
        // Arrange
        Long id = 1L;
        when(invoiceDetailRepository.findById(id)).thenReturn(Optional.empty());

        // Act
        Optional<InvoiceDetailEntity> result = invoiceDetailService.getInvoiceDetailById(id);

        // Assert
        assertFalse(result.isPresent());
    }

    @Test
    public void testCreateInvoiceDetail() {
        // Arrange
        InvoiceDetailEntity inputEntity = new InvoiceDetailEntity();
        InvoiceDetailEntity createdEntity = new InvoiceDetailEntity();
        when(invoiceDetailRepository.save(inputEntity)).thenReturn(createdEntity);

        // Act
        InvoiceDetailEntity result = invoiceDetailService.createInvoiceDetail(inputEntity);

        // Assert
        assertEquals(createdEntity, result);
    }

    @Test
    public void testUpdateInvoiceDetailFound() {
        // Arrange
        Long id = 1L;
        InvoiceDetailEntity updatedEntity = new InvoiceDetailEntity();
        when(invoiceDetailRepository.existsById(id)).thenReturn(true);
        when(invoiceDetailRepository.save(updatedEntity)).thenReturn(updatedEntity);

        // Act
        InvoiceDetailEntity result = invoiceDetailService.updateInvoiceDetail(id, updatedEntity);

        // Assert
        assertEquals(updatedEntity, result);
    }

    @Test
    public void testUpdateInvoiceDetailNotFound() {
        // Arrange
        Long id = 1L;
        InvoiceDetailEntity updatedEntity = new InvoiceDetailEntity();
        when(invoiceDetailRepository.existsById(id)).thenReturn(false);

        // Act
        InvoiceDetailEntity result = invoiceDetailService.updateInvoiceDetail(id, updatedEntity);

        // Assert
        assertNull(result);
    }

    @Test
    public void testDeleteInvoiceDetail() {
        // Arrange
        Long id = 1L;

        // Act
        invoiceDetailService.deleteInvoiceDetail(id);

        // Assert
        verify(invoiceDetailRepository, times(1)).deleteById(id);
    }

}