package com.microservice.employees.service;

import org.springframework.stereotype.Service;

import com.microservice.employees.entity.Employees;

@Service
public interface EmploeesService {
	
	Employees saveEmployees(Employees employees );
	

	ResponseDto  getEmployeeById(long id);
	

}
