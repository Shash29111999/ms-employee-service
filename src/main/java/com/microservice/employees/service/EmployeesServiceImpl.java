package com.microservice.employees.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.microservice.employees.entity.Employees;
import com.microservice.employees.repository.EmployeesRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeesServiceImpl implements EmploeesService {
	
	@Autowired
	EmployeesRepository employeesRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	
//	@Autowired
//	private WebClient webClient;
	
	//private final APIClients apiClient;

//    @Autowired
//    public EmployeesServiceImpl(APIClients apiClient) {
//        this.apiClient = apiClient;
//    }
   // private APIClient apiClient;

	@Override
	public Employees saveEmployees(Employees employees) {
			return employeesRepo.save(employees);
	}

	@Override
	public ResponseDto getEmployeeById(long id) {
		
		ResponseDto rdt = new ResponseDto();
		Employees em =  employeesRepo.findById(id).get();
		
		EmployeeDto emDto = mapEmployee(em);
		
		
		ResponseEntity<DepartmentDto> respEntity = restTemplate.getForEntity("http://DEPARTMENT/api/departments/get/"+ em.getDepartmentId(), DepartmentDto.class);
		
//		DepartmentDto departmentDto =  webClient.get()
//        .uri("http://localhost:8084/api/departments/get/" + em.getDepartmentId())
//        .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                        .block();
		
		//DepartmentDto departmentDto = apiClient.getDepartmentById(em.getDepartmentId());
		
		DepartmentDto departmentDto = respEntity.getBody();
		
		rdt.setDt(departmentDto);
		rdt.setEm(emDto);
		
		return rdt;
	}

	private EmployeeDto mapEmployee(Employees em) {
		EmployeeDto emDto = new EmployeeDto();
		
		emDto.setEmail(em.getEmail());
		emDto.setId(em.getId());
		emDto.setFirstName(em.getFirstName());
		emDto.setLastName(em.getLastName());
		
		// TODO Auto-generated method stub
		return emDto;
	}
	
	

}
