package com.management.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.management.employee.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	@Query(value="select id,name,gender,age from employee where gender=? and age between ? and ?;",nativeQuery = true)
	List<Employee> getSelectEmployees(String gender, int minAge,int maxAge);

}
