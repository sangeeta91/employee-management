package com.management.employee.service;

import com.management.employee.entity.Credentials;

public interface CredentialService {
 
	String getLoginDetails(Credentials creds) throws Exception;
}
