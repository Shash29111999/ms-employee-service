package com.microservice.employees.service;



public class ResponseDto {
	private DepartmentDto dt;
	private EmployeeDto em;
	public ResponseDto(DepartmentDto dt, EmployeeDto em) {
		super();
		this.dt = dt;
		this.em = em;
	}
	public ResponseDto() {
		// TODO Auto-generated constructor stub
	}
	public DepartmentDto getDt() {
		return dt;
	}
	public void setDt(DepartmentDto dt) {
		this.dt = dt;
	}
	public EmployeeDto getEm() {
		return em;
	}
	public void setEm(EmployeeDto em) {
		this.em = em;
	}

}
