package com.example.employee.models;

import lombok.Data;

@Data
public class Address {

    private Long id;
    private String street;
    private String state;
    private String zipCode;
    private String country;

}
