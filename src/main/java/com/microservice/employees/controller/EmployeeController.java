package com.microservice.employees.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.employees.entity.Employees;
import com.microservice.employees.service.EmploeesService;
import com.microservice.employees.service.ResponseDto;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {
	
	@Autowired
	EmploeesService dps;
	
	@PostMapping("save")
	public ResponseEntity<Employees> saveDepartment( @RequestBody Employees employee){
		Employees savedDps = dps.saveEmployees(employee);
		return new ResponseEntity<>(savedDps , HttpStatus.CREATED);
	}
	
	@GetMapping("get/{id}")
	public  ResponseEntity<ResponseDto> getDepartmentById(@PathVariable long id){
		
		ResponseDto resp = dps.getEmployeeById(id);
		
		return ResponseEntity.ok(resp);
		
		
	}
	

}
