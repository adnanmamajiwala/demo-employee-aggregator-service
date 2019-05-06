package com.example.employee;


import com.example.employee.models.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping
    public List<Employee> getAll(){
        return service.findAll();
    }

    @PostMapping
    public Employee save(@Valid Employee employee){
        return service.save(employee);
    }
}
