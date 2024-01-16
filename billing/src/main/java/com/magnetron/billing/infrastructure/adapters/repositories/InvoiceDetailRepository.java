package com.magnetron.billing.infrastructure.adapters.repositories;

import com.magnetron.billing.domain.entities.InvoiceDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetailEntity, Long> {
}