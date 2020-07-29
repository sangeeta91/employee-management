package com.management.employee.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.management.employee.entity.Credentials;
import com.management.employee.entity.Employee;
import com.management.employee.service.CredentialService;
import com.management.employee.service.EmployeeService;


@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	CredentialService credentialService;
	
	@PostMapping(value="/employee",produces="application/json;charset=UTF-8")
	public ResponseEntity<String> insertEmployeeDetails(@RequestBody Employee employeeDetails,HttpSession session){
		try {
			String session_user=(String)session.getAttribute("session_user");
			if(session_user!=null && session_user.equalsIgnoreCase("valid_user")) {
			String result=employeeService.insertEmployeeDetails(employeeDetails);
			return new ResponseEntity<>(result,HttpStatus.CREATED);
			}
			else {
				return new ResponseEntity<>("Invalid user",HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}
		catch(Exception e) {
			return new ResponseEntity<>("insert_fail",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(value="/login",produces="application/json;charset=UTF-8")
	public ResponseEntity<String> getLoginDetails(@RequestBody Credentials creds,HttpServletRequest request){
		try {
			String result=credentialService.getLoginDetails(creds);
			if("success".equalsIgnoreCase(result)) {
				request.getSession().setAttribute("session_user", "valid_user");
			}
			return new ResponseEntity<>(result,HttpStatus.OK);

		}
		catch(Exception e) {
			return new ResponseEntity<>("login_fail! No Data Found.Please register",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping(value="/employees",produces="application/json;charset=UTF-8")
	public ResponseEntity<Object> getSelectEmployeeDetails(@RequestParam(value="gender") String gender ,@RequestParam(value="minAge") int minAge,@RequestParam(value="maxAge") int maxAge){
		try {
			List<Employee> employees=employeeService.getSelectEmployeeDetails(gender, minAge, maxAge);
			return new ResponseEntity<>(employees,HttpStatus.OK);

		}
		catch(Exception e) {
			return new ResponseEntity<>("Invalid Data",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
