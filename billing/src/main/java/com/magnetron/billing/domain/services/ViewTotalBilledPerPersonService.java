package com.magnetron.billing.domain.services;

import com.magnetron.billing.application.controllers.dtos.ViewTotalBilledPerPersonDTO;
import com.magnetron.billing.domain.entities.ViewTotalBilledPerPersonEntity;
import com.magnetron.billing.infrastructure.adapters.mappers.ViewTotalBilledPerPersonMapper;
import com.magnetron.billing.infrastructure.adapters.repositories.ViewTotalBilledPerPersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ViewTotalBilledPerPersonService implements ImplViewService<ViewTotalBilledPerPersonDTO> {

    private final ViewTotalBilledPerPersonRepository viewTotalBilledPerPersonRepository;
    private final ViewTotalBilledPerPersonMapper viewTotalBilledPerPersonMapper;

    @Override
    public List<ViewTotalBilledPerPersonDTO> getAll() {
        List<ViewTotalBilledPerPersonEntity> viewTotalBilledPerPersonEntities = viewTotalBilledPerPersonRepository.findAll();
        return viewTotalBilledPerPersonMapper.toDTOList(viewTotalBilledPerPersonEntities);
    }

}