package com.magnetron.billing.infrastructure.adapters.repositories;

import com.magnetron.billing.domain.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

}