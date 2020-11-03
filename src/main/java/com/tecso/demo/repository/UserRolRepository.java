package com.tecso.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tecso.demo.entity.User;
import com.tecso.demo.entity.UserRole;

@Repository("userRolRepository")
public interface UserRolRepository extends JpaRepository<UserRole, Serializable>{
	
	@SuppressWarnings("unchecked")
	public abstract UserRole save(UserRole userRole);
	
	public abstract UserRole findByUser(User user);

}
