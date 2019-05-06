package com.example.employee;

import com.example.employee.feigns.AddressFeignClient;
import com.example.employee.feigns.PersonFeignClient;
import com.example.employee.models.Address;
import com.example.employee.models.Employee;
import com.example.employee.models.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final PersonFeignClient personFeignClient;
    private final AddressFeignClient addressFeignClient;

    public List<Employee> findAll() {
        return personFeignClient.getAllPeople()
                .stream()
                .map(person -> Employee.builder()
                        .id(person.getId())
                        .firstName(person.getFirstName())
                        .lastName(person.getLastName())
                        .address(addressFeignClient.findAddressByPersonId(person.getId()))
                        .build())
                .collect(Collectors.toList());
    }

    public Employee save(Employee employee) {
        Person savedPerson = personFeignClient.save(Person.builder().firstName(employee.getFirstName()).build());
        Address savedAddress = addressFeignClient.save(employee.getAddress());
        return Employee.builder()
                .id(savedPerson.getId())
                .firstName(savedPerson.getFirstName())
                .lastName(savedPerson.getLastName())
                .address(savedAddress)
                .build();
    }
}
