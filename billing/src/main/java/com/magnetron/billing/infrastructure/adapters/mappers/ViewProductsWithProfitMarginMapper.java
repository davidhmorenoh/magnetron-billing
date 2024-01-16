package com.magnetron.billing.infrastructure.adapters.mappers;

import com.magnetron.billing.application.controllers.dtos.ViewProductsWithProfitMarginDTO;
import com.magnetron.billing.domain.entities.ViewProductsWithProfitMarginEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ViewProductsWithProfitMarginMapper {

    private ModelMapper modelMapper;

    public ViewProductsWithProfitMarginDTO toDTO(ViewProductsWithProfitMarginEntity viewProductsWithProfitMarginEntity) {
        return modelMapper.map(viewProductsWithProfitMarginEntity, ViewProductsWithProfitMarginDTO.class);
    }

    public List<ViewProductsWithProfitMarginDTO> toDTOList(List<ViewProductsWithProfitMarginEntity> viewProductsWithProfitMarginEntities) {
        return viewProductsWithProfitMarginEntities.stream().map(this::toDTO).toList();
    }

}