package com.magnetron.billing.infrastructure.adapters.mappers;

import com.magnetron.billing.application.controllers.dtos.ViewProductsByInvoicedQuantityDTO;
import com.magnetron.billing.domain.entities.ViewProductsByInvoicedQuantityEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ViewProductsByInvoicedQuantityMapper {

    private ModelMapper modelMapper;

    public ViewProductsByInvoicedQuantityDTO toDTO(ViewProductsByInvoicedQuantityEntity viewProductsByInvoicedQuantityEntity) {
        return modelMapper.map(viewProductsByInvoicedQuantityEntity, ViewProductsByInvoicedQuantityDTO.class);
    }

    public List<ViewProductsByInvoicedQuantityDTO> toDTOList(List<ViewProductsByInvoicedQuantityEntity> viewProductsByInvoicedQuantityEntities) {
        return viewProductsByInvoicedQuantityEntities.stream().map(this::toDTO).toList();
    }

}