package com.magnetron.billing.infrastructure.adapters.mappers;

import com.magnetron.billing.application.controllers.dtos.InvoiceDetailDTO;
import com.magnetron.billing.domain.entities.InvoiceDetailEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InvoiceDetailMapper {

    private ModelMapper modelMapper;
    private InvoiceHeaderMapper invoiceHeaderMapper;

    public InvoiceDetailDTO toDTO(InvoiceDetailEntity invoiceDetailEntity) {
        return modelMapper.map(invoiceDetailEntity, InvoiceDetailDTO.class);
    }

    public InvoiceDetailEntity toEntity(InvoiceDetailDTO invoiceDetailDTO) {
        return modelMapper.map(invoiceDetailDTO, InvoiceDetailEntity.class);
    }

}