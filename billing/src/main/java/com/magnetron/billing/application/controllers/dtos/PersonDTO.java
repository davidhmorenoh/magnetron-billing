package com.magnetron.billing.application.controllers.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonDTO {

    private Long id;
    private String name;
    private String lastName;
    private String documentType;
    private String document;

}