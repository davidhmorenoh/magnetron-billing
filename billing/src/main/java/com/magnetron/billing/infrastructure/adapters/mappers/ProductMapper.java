package com.magnetron.billing.infrastructure.adapters.mappers;

import com.magnetron.billing.application.controllers.dtos.ProductDTO;
import com.magnetron.billing.domain.entities.ProductEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ProductMapper {

    private ModelMapper modelMapper;

    public ProductDTO toDTO(ProductEntity productEntity) {
        return modelMapper.map(productEntity, ProductDTO.class);
    }

    public ProductEntity toEntity(ProductDTO productDTO) {
        return modelMapper.map(productDTO, ProductEntity.class);
    }

    public List<ProductDTO> toDTOList(List<ProductEntity> productEntities) {
        return productEntities.stream().map(this::toDTO).toList();
    }

}