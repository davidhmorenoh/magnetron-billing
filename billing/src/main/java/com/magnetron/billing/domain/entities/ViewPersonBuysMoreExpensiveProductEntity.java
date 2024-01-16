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
@Subselect("SELECT * FROM ViewPersonBuysMoreExpensiveProduct")
public class ViewPersonBuysMoreExpensiveProductEntity {

    @Id
    @Column(name = "person_id")
    private Long personId;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "product_id")
    private Long productId;
    private String description;
    @Column(name = "most_expensive_product_price")
    private BigDecimal mostExpensiveProductPrice;

}