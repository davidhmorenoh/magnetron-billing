package com.magnetron.billing.infrastructure.adapters.repositories;

import com.magnetron.billing.domain.entities.ViewProductsWithProfitMarginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewProductsWithProfitMarginRepository extends JpaRepository<ViewProductsWithProfitMarginEntity, Long> {
}