package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DAO.EmployeeRepository;
import com.example.Entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repository;
	
	//Create Single Employee
	public Employee createEmployee(Employee emp) 
	{
		return repository.save(emp);		
	}
	
	//Create Multiple Employees
	public List<Employee> createEmployees(List<Employee> emps)
	{
		return repository.saveAll(emps);
	}
	
	//Get Info of Single Employee by Id
	public Employee getEmployeeByID(int id)
	{
		return repository.findById(id).orElse(null);
	}
	
	//Get Info of all Employees
	public List<Employee> getEmployees()
	{
		return repository.findAll();
	}
	
	//Update Employee
	public Employee upadteEmployee(Employee emp)
	{
		Employee oldUser=null;
		Optional<Employee> optionaluser=repository.findById(emp.getId());
		if(optionaluser.isPresent()) {
			oldUser=optionaluser.get();
			oldUser.setName(emp.getName());
			oldUser.setAddress(emp.getAddress());
			repository.save(oldUser);
		}else {
			return new Employee();
		}
		return oldUser;
	}
	
	//Delete Employee
	public String deleteEmployeeById(int id)
	{
		repository.deleteById(id);
		return "Employee Deleted!";
	}
}
