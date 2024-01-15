package com.magnetron.billing.domain.services;

import com.magnetron.billing.application.controllers.dtos.PersonDTO;
import com.magnetron.billing.domain.entities.PersonEntity;
import com.magnetron.billing.infrastructure.adapters.mappers.PersonMapper;
import com.magnetron.billing.infrastructure.adapters.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public List<PersonDTO> getAllPersonEntities() {
        List<PersonEntity> personEntities = personRepository.findAll();
        return personMapper.toDTOList(personEntities);
    }

    public Optional<PersonDTO> getPersonById(Long id) {
        return personRepository.findById(id).map(personMapper::toDTO);
    }

    public PersonDTO createPerson(PersonDTO personDTO) {
        PersonEntity personEntity = personRepository.save(personMapper.toEntity(personDTO));
        return personMapper.toDTO(personEntity);
    }

    public Optional<PersonDTO> updatePerson(Long id, PersonDTO personDTO) {
        return personRepository.findById(id).map(personEntity -> {
            personEntity.setDocument(personDTO.getDocument());
            personEntity.setName(personDTO.getName());
            personEntity.setDocumentType(personDTO.getDocumentType());
            personEntity.setLastName(personDTO.getLastName());

            PersonEntity updatedPerson = personRepository.save(personEntity);
            return personMapper.toDTO(updatedPerson);
        });
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

}