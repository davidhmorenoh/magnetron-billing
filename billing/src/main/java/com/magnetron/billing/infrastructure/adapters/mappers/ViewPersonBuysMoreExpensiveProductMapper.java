package com.magnetron.billing.infrastructure.adapters.mappers;

import com.magnetron.billing.application.controllers.dtos.ViewPersonBuysMoreExpensiveProductDTO;
import com.magnetron.billing.domain.entities.ViewPersonBuysMoreExpensiveProductEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ViewPersonBuysMoreExpensiveProductMapper {

    private ModelMapper modelMapper;

    public ViewPersonBuysMoreExpensiveProductDTO toDTO(ViewPersonBuysMoreExpensiveProductEntity viewPersonBuysMoreExpensiveProductEntity) {
        return modelMapper.map(viewPersonBuysMoreExpensiveProductEntity, ViewPersonBuysMoreExpensiveProductDTO.class);
    }

    public List<ViewPersonBuysMoreExpensiveProductDTO> toDTOList(List<ViewPersonBuysMoreExpensiveProductEntity> viewPersonBuysMoreExpensiveProductEntities) {
        return viewPersonBuysMoreExpensiveProductEntities.stream().map(this::toDTO).toList();
    }

}