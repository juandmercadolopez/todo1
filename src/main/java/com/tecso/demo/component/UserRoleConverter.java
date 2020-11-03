package com.tecso.demo.component;

import com.tecso.demo.entity.UserRole;
import com.tecso.demo.model.UserRoleModel;

public class UserRoleConverter {
	
	public static UserRoleModel convertUserRoleEntityToModel(UserRole userRole) {
		UserRoleModel userRoleModel = new UserRoleModel(userRole.getRole(), userRole.getUser().getUsername(), true);
		return userRoleModel;		
	}

}
