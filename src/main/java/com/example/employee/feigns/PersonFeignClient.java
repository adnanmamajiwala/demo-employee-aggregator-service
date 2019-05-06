package com.example.employee.feigns;

import com.example.employee.models.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
@FeignClient(name = "person-service")
public interface PersonFeignClient {

    @GetMapping("/people")
    List<Person> getAllPeople();

    @GetMapping("/people/{id}")
    Person findPeopleById(@PathVariable("id") Long id);

    @PostMapping("/people")
    Person save(Person person);
}
