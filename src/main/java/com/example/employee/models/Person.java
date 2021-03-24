package com.example.employee.models;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {

    private Long id;
    private String firstName;
    private String lastName;

}
