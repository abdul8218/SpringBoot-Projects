package com.abdul.microservices.services;

import java.util.List;

import com.abdul.microservices.entities.user;

public interface userService {

	
	user createUser(user user);
	user updateUser(user user,String userId );
	List<user> getAll();
	void delete(String userId);
	user getUserById(String userId);
	
	
	
	
}
