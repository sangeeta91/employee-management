package com.management.employee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.management.employee.entity.Credentials;
import com.management.employee.repository.CredentialRepository;
import com.management.employee.service.CredentialService;

@Service
public class CredentialServiceImpl implements CredentialService{
	
	@Autowired
	CredentialRepository credentialRepository;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public String getLoginDetails(Credentials creds) throws Exception {
		Credentials actualCreds=credentialRepository.validateEmployee(creds.getUsername(),creds.getPassword());
		if(actualCreds.getPassword()!=null) {
			return "success";
		}				
		else {
			throw new Exception("User is not registered");
		}
	}

}
