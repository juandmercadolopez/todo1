package com.tecso.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tecso.demo.component.UserRoleConverter;
import com.tecso.demo.entity.User;
import com.tecso.demo.entity.UserRole;
import com.tecso.demo.model.UserRoleModel;
import com.tecso.demo.repository.UserRolRepository;
import com.tecso.demo.service.UserRolService;

@Service
public class UserRolServiceImpl implements UserRolService {

	@Autowired
	@Qualifier("userRolRepository")
	private UserRolRepository userRolRepository;

	@Override
	public UserRole addUserRole(String rol, User user) throws Exception {
		UserRole userRole = new UserRole();
		userRole.setRole(rol);
		userRole.setUser(user);
		return userRolRepository.save(userRole);
	}

	@Override
	public UserRoleModel getByUsername(String username) throws Exception {
		UserRoleModel userRoleModel = null;
		User user = new User();
		user.setUsername(username);
		userRoleModel = UserRoleConverter.convertUserRoleEntityToModel(userRolRepository.findByUser(user));
		return userRoleModel;
	}

}
