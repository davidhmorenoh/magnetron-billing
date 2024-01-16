package com.magnetron.billing.infrastructure.adapters.repositories;

import com.magnetron.billing.domain.entities.InvoiceHeaderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceHeaderRepository extends JpaRepository<InvoiceHeaderEntity, Long> {
}