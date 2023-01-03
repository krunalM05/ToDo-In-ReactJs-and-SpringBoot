package com.employee.system.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.system.entities.EmployeeEntity;
import com.employee.system.models.Employee;
import com.employee.system.repository.EmployeeRepository;
import com.employee.system.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee createEmployee(Employee employee) {
		EmployeeEntity empEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, empEntity);
//		System.out.println(empEntity.getFirstName());
//		System.out.println(employee.getFirstName());
		employeeRepository.save(empEntity);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<EmployeeEntity> empEntityList = employeeRepository.findAll();
		List<Employee> empList = empEntityList.stream().map(enList -> new Employee(enList.getId(),enList.getFirstName(),
						enList.getLastName(),enList.getEmail(),enList.getTelNumber(),enList.getDob(),enList.getGender()))
						.collect(Collectors.toList());
		return empList;
	}

	@Override
	public Boolean deleteEmployee(Integer id) {
		EmployeeEntity emp = employeeRepository.findById(id).get();
		employeeRepository.delete(emp);
		return true;
		
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		EmployeeEntity empEntity = employeeRepository.findById(id).get();
		Employee emp = new Employee();
		BeanUtils.copyProperties(empEntity,emp);
		return emp;
	}

	@Override
	public Employee editEmployee(Integer id, Employee employee) {
		EmployeeEntity empEntity = employeeRepository.findById(id).get();
		empEntity.setEmail(employee.getEmail());
		empEntity.setDob(employee.getDob());
		empEntity.setFirstName(employee.getFirstName());
		empEntity.setGender(employee.getGender());
		empEntity.setLastName(employee.getLastName());
		empEntity.setTelNumber(employee.getTelNumber());
		employeeRepository.save(empEntity);
		return employee;
	}

	
}
