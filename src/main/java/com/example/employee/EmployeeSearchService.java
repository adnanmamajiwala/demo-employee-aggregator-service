package com.example.employee;

import com.example.employee.feigns.AddressFeignService;
import com.example.employee.feigns.PersonFeignService;
import com.example.employee.models.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeSearchService {

    private final PersonFeignService personFeignService;
    private final AddressFeignService addressFeignService;

    public List<Employee> findAll() {
        return null;
    }
}
