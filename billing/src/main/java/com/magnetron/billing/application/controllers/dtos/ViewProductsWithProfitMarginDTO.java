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
public class ViewProductsWithProfitMarginDTO {

    private Long productId;
    private String description;
    private Long invoiceNumber;
    private BigDecimal totalRevenue;
    private BigDecimal totalCost;
    private BigDecimal profitMargin;

}