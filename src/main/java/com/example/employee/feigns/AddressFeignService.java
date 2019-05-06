package com.example.employee.feigns;

import com.example.employee.models.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@FeignClient(name="address-service")
public interface AddressFeignService {

    @GetMapping("/addresses")
    List<Address> getAllAddresses();
}
