package com.magnetron.billing.domain.services;

import com.magnetron.billing.application.controllers.dtos.ViewPersonBuysMoreExpensiveProductDTO;
import com.magnetron.billing.domain.entities.ViewPersonBuysMoreExpensiveProductEntity;
import com.magnetron.billing.infrastructure.adapters.mappers.ViewPersonBuysMoreExpensiveProductMapper;
import com.magnetron.billing.infrastructure.adapters.repositories.ViewPersonBuysMoreExpensiveProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ViewPersonBuysMoreExpensiveProductService implements ImplViewService<ViewPersonBuysMoreExpensiveProductDTO> {

    private final ViewPersonBuysMoreExpensiveProductRepository viewPersonBuysMoreExpensiveProductRepository;
    private final ViewPersonBuysMoreExpensiveProductMapper viewPersonBuysMoreExpensiveProductMapper;

    @Override
    public List<ViewPersonBuysMoreExpensiveProductDTO> getAll() {
        List<ViewPersonBuysMoreExpensiveProductEntity> viewPersonBuysMoreExpensiveProductEntities = viewPersonBuysMoreExpensiveProductRepository.findAll();
        return viewPersonBuysMoreExpensiveProductMapper.toDTOList(viewPersonBuysMoreExpensiveProductEntities);
    }

}