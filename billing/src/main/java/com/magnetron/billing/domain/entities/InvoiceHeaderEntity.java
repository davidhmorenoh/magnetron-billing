package com.magnetron.billing.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "invoice_header")
public class InvoiceHeaderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private PersonEntity person;

}