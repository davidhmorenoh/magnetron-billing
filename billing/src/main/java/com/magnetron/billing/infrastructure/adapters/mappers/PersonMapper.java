package com.magnetron.billing.infrastructure.adapters.mappers;

import com.magnetron.billing.application.controllers.dtos.PersonDTO;
import com.magnetron.billing.domain.entities.PersonEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PersonMapper {

    private ModelMapper modelMapper;

    public PersonDTO toDTO(PersonEntity personEntity) {
        return modelMapper.map(personEntity, PersonDTO.class);
    }

    public PersonEntity toEntity(PersonDTO personDTO) {
        return modelMapper.map(personDTO, PersonEntity.class);
    }

    public List<PersonDTO> toDTOList(List<PersonEntity> personEntities) {
        return personEntities.stream().map(this::toDTO).toList();
    }

}