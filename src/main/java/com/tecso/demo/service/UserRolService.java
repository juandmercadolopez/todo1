package com.tecso.demo.service;

import com.tecso.demo.entity.User;
import com.tecso.demo.entity.UserRole;
import com.tecso.demo.model.UserRoleModel;

public interface UserRolService {
	
	public abstract UserRole addUserRole(String rol, User user) throws Exception;
	
	public UserRoleModel getByUsername(String username) throws Exception;

}
