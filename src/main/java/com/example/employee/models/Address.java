package com.example.employee.models;

import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {

    private Long id;

    @NotNull
    private String street;

    @NotNull
    private String state;

    @NotNull
    private String zipCode;

    @NotNull
    private String country;

    @NotNull
    private Long personId;
}
