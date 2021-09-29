package com.chanakyaems.employeemanager.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chanakyaems.employeemanager.model.Employee;
import com.chanakyaems.employeemanager.repo.EmployeeRepo;

@Service
@Transactional
public class EmployeeService {

	private final EmployeeRepo employeeRepo;
	
	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	public Employee addEmployee(Employee employee) {
		
		employee.setEmployeeCode(UUID.randomUUID().toString());
		
		return employeeRepo.save(employee);
		
	}
	
	public List<Employee> findAllEmployees(){
		
		return employeeRepo.findAll();
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	public Employee findEmployeeById(Long id) {
		
		try {
			return employeeRepo.findEmployeeById(id);
			
		}catch(Exception ex) {
			System.out.println("Employee by that id not found.");
			return null;
		}
		
		//return (Optional) employeeRepo.findEmployeeById(id)
			//	.orElseThrow(()-> new UserNotFoundException("User by id"+id+". Not found"));
	}
	
	public void deleteEmployee(Long id) {
		employeeRepo.deleteEmployeeById(id);
	}
}
