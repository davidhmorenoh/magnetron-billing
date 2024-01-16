package com.magnetron.billing.application.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ViewProductsByInvoicedQuantityDTO {

    private Long id;
    private String description;
    private BigDecimal amountBilled;

}