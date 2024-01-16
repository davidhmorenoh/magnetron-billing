package com.magnetron.billing.infraestructure.adapters.mappers;

import com.magnetron.billing.application.controllers.dtos.BillDTO;
import com.magnetron.billing.domain.entities.InvoiceHeaderEntity;
import com.magnetron.billing.infrastructure.adapters.mappers.InvoiceHeaderMapper;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class InvoiceHeaderMapperTest {

    private InvoiceHeaderMapper invoiceHeaderMapper;

    @Before
    public void setUp() {
        ModelMapper modelMapper = new ModelMapper();
        this.invoiceHeaderMapper = new InvoiceHeaderMapper(modelMapper);
    }

    @Test
    public void testToDTO() {
        // Arrange
        InvoiceHeaderEntity entity = new InvoiceHeaderEntity();
        entity.setId(1L);
        // Set other fields as needed...

        // Act
        BillDTO dto = invoiceHeaderMapper.toDTO(entity);

        // Assert
        assertNotNull(dto);
        assertEquals(entity.getId(), dto.getId());
        // Add assertions for other fields...
    }

    @Test
    public void testToEntity() {
        // Arrange
        BillDTO dto = new BillDTO();
        dto.setId(1L);
        // Set other fields as needed...

        // Act
        InvoiceHeaderEntity entity = invoiceHeaderMapper.toEntity(dto);

        // Assert
        assertNotNull(entity);
        assertEquals(dto.getId(), entity.getId());
        // Add assertions for other fields...
    }

}