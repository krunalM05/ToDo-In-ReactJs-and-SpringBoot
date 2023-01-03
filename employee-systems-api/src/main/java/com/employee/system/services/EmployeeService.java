package com.employee.system.services;

import java.util.List;

import com.employee.system.models.Employee;

public interface EmployeeService{

	//create new employee
	Employee createEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Boolean deleteEmployee(Integer id);

	Employee getEmployeeById(Integer id);

	Employee editEmployee(Integer id,Employee employee);
	
	
}
