package com.management.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.management.employee.entity.Credentials;

@Repository
public interface CredentialRepository extends JpaRepository<Credentials, String>{

	
	@Query(value="select username,password from credentials where username=? and password=?;",nativeQuery = true)
	Credentials validateEmployee(String username, String password);
}
