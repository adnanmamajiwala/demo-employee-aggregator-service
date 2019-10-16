package com.example.employee;


import com.example.employee.models.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200x")
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
