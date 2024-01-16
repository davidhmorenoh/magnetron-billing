package com.magnetron.billing.domain.services;

import com.magnetron.billing.application.controllers.dtos.ViewProductsWithProfitMarginDTO;
import com.magnetron.billing.domain.entities.ViewProductsWithProfitMarginEntity;
import com.magnetron.billing.infrastructure.adapters.mappers.ViewProductsWithProfitMarginMapper;
import com.magnetron.billing.infrastructure.adapters.repositories.ViewProductsWithProfitMarginRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ViewProductsWithProfitMarginService implements ImplViewService<ViewProductsWithProfitMarginDTO> {

    private final ViewProductsWithProfitMarginRepository viewProductsWithProfitMarginRepository;
    private final ViewProductsWithProfitMarginMapper viewProductsWithProfitMarginMapper;

    @Override
    public List<ViewProductsWithProfitMarginDTO> getAll() {
        List<ViewProductsWithProfitMarginEntity> viewProductsWithProfitMarginEntities = viewProductsWithProfitMarginRepository.findAll();
        return viewProductsWithProfitMarginMapper.toDTOList(viewProductsWithProfitMarginEntities);
    }

}