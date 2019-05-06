package com.example.employee.feigns;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

@Service
@FeignClient(name="address-service")
public interface PersonFeignService {


}
