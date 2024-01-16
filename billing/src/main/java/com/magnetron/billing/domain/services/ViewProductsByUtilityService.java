package com.magnetron.billing.domain.services;

import com.magnetron.billing.application.controllers.dtos.ViewProductsByUtilityDTO;
import com.magnetron.billing.domain.entities.ViewProductsByUtilityEntity;
import com.magnetron.billing.infrastructure.adapters.mappers.ViewProductsByUtilityMapper;
import com.magnetron.billing.infrastructure.adapters.repositories.ViewProductsByUtilityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ViewProductsByUtilityService implements ImplViewService<ViewProductsByUtilityDTO> {

    private final ViewProductsByUtilityRepository viewProductsByUtilityRepository;
    private final ViewProductsByUtilityMapper viewProductsByUtilityMapper;

    @Override
    public List<ViewProductsByUtilityDTO> getAll() {
        List<ViewProductsByUtilityEntity> viewProductsByUtilityEntities = viewProductsByUtilityRepository.findAll();
        return viewProductsByUtilityMapper.toDTOList(viewProductsByUtilityEntities);
    }

}