package com.magnetron.billing.domain.entities;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Setter
@Table(name = "invoice_detail")
public class InvoiceDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer line;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
    @ManyToOne
    @JoinColumn(name = "invoice_header_id")
    private InvoiceHeaderEntity invoiceHeader;

}