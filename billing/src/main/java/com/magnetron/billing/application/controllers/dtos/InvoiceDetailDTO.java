package com.magnetron.billing.application.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InvoiceDetailDTO {

    private Long id;
    private Integer line;
    private Integer quantity;
    private Long productId;  // Product ID

}