package com.magnetron.billing.domain.services;

import com.magnetron.billing.domain.entities.PersonEntity;
import com.magnetron.billing.infrastructure.adapters.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonEntity> getAllPeople() {
        return personRepository.findAll();
    }

    public Optional<PersonEntity> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public PersonEntity createPerson(PersonEntity personEntity) {
        return personRepository.save(personEntity);
    }

    public PersonEntity updatePerson(Long id, PersonEntity updatedPersonEntity) {
        if (personRepository.existsById(id)) {
            updatedPersonEntity.setId(id);
            return personRepository.save(updatedPersonEntity);
        }
        return null; // Manejo de error si la persona no existe
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

}