package com.example.employee.feigns;

import com.example.employee.models.Address;
import com.example.employee.models.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@FeignClient(name="address-service")
public interface AddressFeignClient {

    @GetMapping("/addresses")
    List<Address> getAllAddresses();

    @GetMapping("/addresses/{id}")
    Address findAddressById(@PathVariable("id") Long id);

    @GetMapping("/addresses/search")
    Address findAddressByPersonId(@RequestParam("personId") Long id);

    @PostMapping("/addresses")
    Address save(Address address);
}
