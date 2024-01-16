package com.magnetron.billing.infrastructure.adapters.mappers;

import com.magnetron.billing.application.controllers.dtos.ViewProductsByUtilityDTO;
import com.magnetron.billing.domain.entities.ViewProductsByUtilityEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ViewProductsByUtilityMapper {

    private ModelMapper modelMapper;

    public ViewProductsByUtilityDTO toDTO(ViewProductsByUtilityEntity viewProductsByUtilityEntity) {
        return modelMapper.map(viewProductsByUtilityEntity, ViewProductsByUtilityDTO.class);
    }

    public List<ViewProductsByUtilityDTO> toDTOList(List<ViewProductsByUtilityEntity> viewProductsByUtilityEntities) {
        return viewProductsByUtilityEntities.stream().map(this::toDTO).toList();
    }

}