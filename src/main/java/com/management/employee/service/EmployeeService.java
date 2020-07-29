package com.management.employee.service;

import java.util.List;

import com.management.employee.entity.Employee;

public interface EmployeeService {

	String insertEmployeeDetails(Employee employeeDetails) throws Exception;
	List<Employee> getSelectEmployeeDetails(String gender, int minAge, int maxAge) throws Exception;
}
