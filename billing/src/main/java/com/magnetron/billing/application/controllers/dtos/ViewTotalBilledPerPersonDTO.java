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
public class ViewTotalBilledPerPersonDTO {

    private Long id;
    private String name;
    private String lastName;
    private BigDecimal totalBilled;

}