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
@Subselect("SELECT * FROM ViewTotalBilledPerPerson")
public class ViewTotalBilledPerPersonEntity {

    @Id
    private Long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "total_billed")
    private BigDecimal totalBilled;

}