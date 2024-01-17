package com.microservice.employees.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(value = "DEPARTMENT-SERVICE-xyzabc", url = "http://localhost:8084")
public interface APIClients  {
    @GetMapping(value = "/api/departments/get/{id}")
	
    DepartmentDto getDepartmentById(@PathVariable("id") long departmentId) ;
}