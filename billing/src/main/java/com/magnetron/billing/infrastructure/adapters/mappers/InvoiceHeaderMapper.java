package com.magnetron.billing.infrastructure.adapters.mappers;

import com.magnetron.billing.application.controllers.dtos.BillDTO;
import com.magnetron.billing.domain.entities.InvoiceHeaderEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InvoiceHeaderMapper {

    private ModelMapper modelMapper;

    public BillDTO toDTO(InvoiceHeaderEntity invoiceHeaderEntity) {
        return modelMapper.map(invoiceHeaderEntity, BillDTO.class);
    }

    public InvoiceHeaderEntity toEntity(BillDTO billDTO) {
        return modelMapper.map(billDTO, InvoiceHeaderEntity.class);
    }

}