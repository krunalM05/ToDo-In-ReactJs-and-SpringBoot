package com.employee.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.employee.system.entities.EmployeeEntity;


public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

}
