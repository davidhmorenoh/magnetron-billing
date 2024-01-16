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
@Subselect("SELECT * FROM ViewProductsWithProfitMargin")
public class ViewProductsWithProfitMarginEntity {

    @Id
    @Column(name = "product_id")
    private Long productId;
    private String description;
    @Column(name = "invoice_number")
    private Long invoiceNumber;
    @Column(name = "total_revenue")
    private BigDecimal totalRevenue;
    @Column(name = "total_cost")
    private BigDecimal totalCost;
    @Column(name = "profit_margin")
    private BigDecimal profitMargin;

}