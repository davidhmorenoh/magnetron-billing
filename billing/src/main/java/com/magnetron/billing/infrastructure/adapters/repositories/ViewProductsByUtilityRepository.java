package com.magnetron.billing.infrastructure.adapters.repositories;

import com.magnetron.billing.domain.entities.ViewProductsByUtilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewProductsByUtilityRepository extends JpaRepository<ViewProductsByUtilityEntity, Long> {
}