package com.example.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
