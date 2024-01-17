package com.microservice.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.microservice.employees.entity.Employees;

@Service
public interface EmployeesRepository extends JpaRepository<Employees, Long> {

}
