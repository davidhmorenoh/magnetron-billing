package com.magnetron.billing.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Subselect;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
@Subselect("SELECT * FROM ViewProductsByInvoicedQuantity")
public class ViewProductsByInvoicedQuantityEntity {

    @Id
    private Long id;
    private String description;
    @Column(name = "amount_billed")
    private BigDecimal amountBilled;

}