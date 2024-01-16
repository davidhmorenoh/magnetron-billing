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
@Subselect("SELECT * FROM ViewProductsByUtility")
public class ViewProductsByUtilityEntity {

    @Id
    @Column(name = "product_id")
    private Long productId;
    private String description;
    @Column(name = "invoice_number")
    private Long invoiceNumber;
    @Column(name = "profit_generated")
    private BigDecimal profitGenerated;

}