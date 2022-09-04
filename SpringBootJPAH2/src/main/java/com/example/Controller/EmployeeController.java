package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Employee;
import com.example.Service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee emp)
	{
		return service.createEmployee(emp);
	}
	
	@PostMapping("/addEmployees")
	public List<Employee> addEmployees(@RequestBody List<Employee> emps)
	{
		return service.createEmployees(emps);
	}
	
	@GetMapping("/Employee/{id}")
	public Employee getEmployee(@PathVariable int id)
	{
		return service.getEmployeeByID(id);
	}
	
	@GetMapping("/Employees")
	public List<Employee> getEmployees()
	{
		return service.getEmployees();
	}
	
	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee emp)
	{
		return service.upadteEmployee(emp);
	}
	
	@DeleteMapping("/Employee/{id}")
	public String deleteEmployee(@PathVariable int id)
	{
		return service.deleteEmployeeById(id);
	}

}
