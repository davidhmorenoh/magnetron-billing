package com.magnetron.billing.infrastructure.adapters.mappers;

import com.magnetron.billing.application.controllers.dtos.ViewTotalBilledPerPersonDTO;
import com.magnetron.billing.domain.entities.ViewTotalBilledPerPersonEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ViewTotalBilledPerPersonMapper {

    private ModelMapper modelMapper;

    public ViewTotalBilledPerPersonDTO toDTO(ViewTotalBilledPerPersonEntity viewTotalBilledPerPersonEntity) {
        return modelMapper.map(viewTotalBilledPerPersonEntity, ViewTotalBilledPerPersonDTO.class);
    }

    public List<ViewTotalBilledPerPersonDTO> toDTOList(List<ViewTotalBilledPerPersonEntity> viewTotalBilledPerPersonEntities) {
        return viewTotalBilledPerPersonEntities.stream().map(this::toDTO).toList();
    }

}