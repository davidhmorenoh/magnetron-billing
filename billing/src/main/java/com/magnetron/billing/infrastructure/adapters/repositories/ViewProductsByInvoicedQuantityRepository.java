package com.magnetron.billing.infrastructure.adapters.repositories;

import com.magnetron.billing.domain.entities.ViewProductsByInvoicedQuantityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewProductsByInvoicedQuantityRepository extends JpaRepository<ViewProductsByInvoicedQuantityEntity, Long> {
}