package com.magnetron.billing.infraestructure.adapters.mappers;

import com.magnetron.billing.application.controllers.dtos.InvoiceDetailDTO;
import com.magnetron.billing.domain.entities.InvoiceDetailEntity;
import com.magnetron.billing.infrastructure.adapters.mappers.InvoiceDetailMapper;
import com.magnetron.billing.infrastructure.adapters.mappers.InvoiceHeaderMapper;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class InvoiceDetailMapperTest {

    private InvoiceDetailMapper invoiceDetailMapper;

    @Before
    public void setUp() {
        ModelMapper modelMapper = new ModelMapper();
        InvoiceHeaderMapper invoiceHeaderMapper = new InvoiceHeaderMapper(modelMapper);
        this.invoiceDetailMapper = new InvoiceDetailMapper(modelMapper, invoiceHeaderMapper);
    }

    @Test
    public void testToDTO() {
        // Arrange
        InvoiceDetailEntity entity = new InvoiceDetailEntity();
        entity.setId(1L);
        entity.setQuantity(2);
        // Set other fields as needed...

        // Act
        InvoiceDetailDTO dto = invoiceDetailMapper.toDTO(entity);

        // Assert
        assertNotNull(dto);
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getQuantity(), dto.getQuantity());
        // Add assertions for other fields...
    }

    @Test
    public void testToEntity() {
        // Arrange
        InvoiceDetailDTO dto = new InvoiceDetailDTO();
        dto.setId(1L);
        dto.setQuantity(2);
        // Set other fields as needed...

        // Act
        InvoiceDetailEntity entity = invoiceDetailMapper.toEntity(dto);

        // Assert
        assertNotNull(entity);
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getQuantity(), entity.getQuantity());
        // Add assertions for other fields...
    }

}