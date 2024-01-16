package com.magnetron.billing.domain.services;

import com.magnetron.billing.application.controllers.dtos.ViewProductsByInvoicedQuantityDTO;
import com.magnetron.billing.domain.entities.ViewProductsByInvoicedQuantityEntity;
import com.magnetron.billing.infrastructure.adapters.mappers.ViewProductsByInvoicedQuantityMapper;
import com.magnetron.billing.infrastructure.adapters.repositories.ViewProductsByInvoicedQuantityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ViewProductsByInvoicedQuantityService implements ImplViewService<ViewProductsByInvoicedQuantityDTO> {

    private final ViewProductsByInvoicedQuantityRepository viewProductsByInvoicedQuantityRepository;
    private final ViewProductsByInvoicedQuantityMapper viewProductsByInvoicedQuantityMapper;

    @Override
    public List<ViewProductsByInvoicedQuantityDTO> getAll() {
        List<ViewProductsByInvoicedQuantityEntity> viewProductsByInvoicedQuantityEntities = viewProductsByInvoicedQuantityRepository.findAll();
        return viewProductsByInvoicedQuantityMapper.toDTOList(viewProductsByInvoicedQuantityEntities);
    }

}