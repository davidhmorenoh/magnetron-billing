package com.magnetron.billing.application.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BillDTO {

    private Long id;
    private Integer number;
    private Date date;
    private Long personId; // Person ID
    @JsonProperty("details")
    private List<InvoiceDetailDTO> invoiceDetailDTOS;

}