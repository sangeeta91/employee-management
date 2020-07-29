package com.management.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.management.employee.entity.Employee;
import com.management.employee.repository.EmployeeRepository;
import com.management.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insertEmployeeDetails(Employee employeeDetails) throws Exception {
		Employee newEmployee=employeeRepository.saveAndFlush(employeeDetails);
		if(newEmployee.getId()!=null)
			return "success";
		else {
			throw new Exception("Error while saving employee data");
		}
	}

	@Override
	public List<Employee> getSelectEmployeeDetails(String gender, int minAge, int maxAge) throws Exception {
		List<Employee> employees=employeeRepository.getSelectEmployees(gender, minAge, maxAge);
		return employees;
	}

}
