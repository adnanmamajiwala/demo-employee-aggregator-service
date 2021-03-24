package com.example.employee;

import com.example.employee.feigns.AddressFeignClient;
import com.example.employee.feigns.PersonFeignClient;
import com.example.employee.models.Address;
import com.example.employee.models.Employee;
import com.example.employee.models.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final PersonFeignClient personFeignClient;
    private final AddressFeignClient addressFeignClient;

    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        List<Person> people = personFeignClient.getAllPeople();
        for (Person person : people) {
            log.debug("Person - {}", person.toString());
            Address address = addressFeignClient.findAddressByPersonId(person.getId());
            log.debug("Address - {}", address.toString());
            Employee employee = Employee.builder()
                    .id(person.getId())
                    .firstName(person.getFirstName())
                    .lastName(person.getLastName())
                    .address(address)
                    .build();
            log.debug("Employee - {}", employee.toString());
            employees.add(employee);
        }
        return employees;
//        return personFeignClient.getAllPeople()
//                .stream()
//                .map(person -> Employee.builder()
//                        .id(person.getId())
//                        .firstName(person.getFirstName())
//                        .lastName(person.getLastName())
//                        .address(addressFeignClient.findAddressByPersonId(person.getId()))
//                        .build())
//                .collect(Collectors.toList());
    }

    public Employee save(Employee employee) {
        Person savedPerson = personFeignClient.save(getPerson(employee));
        Address savedAddress = addressFeignClient.save(employee.getAddress());
        return Employee.builder()
                .id(savedPerson.getId())
                .firstName(savedPerson.getFirstName())
                .lastName(savedPerson.getLastName())
                .address(savedAddress)
                .build();
    }

    private Person getPerson(Employee employee) {
        return Person.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .build();
    }
}
