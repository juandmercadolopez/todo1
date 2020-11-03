package com.tecso.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="user_roles", uniqueConstraints = @UniqueConstraint(columnNames = {"role", "users_username"}))
public class UserRole {
	@Id
	@GeneratedValue
	@Column(name="user_role_id", unique = true)
	private Integer userRoleId;	
	
	@Column(name="role", nullable = false, length = 45)
	private String role;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="users_username", referencedColumnName = "username", nullable = false)
	private User user;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "userRol")
	private Set<Opcion> opciones = new HashSet<Opcion>();
	
	public UserRole() {
		
	}	

	public UserRole(Integer userRoleId, String role, User user, Set<Opcion> opciones) {
		super();
		this.userRoleId = userRoleId;
		this.role = role;
		this.user = user;
		this.opciones = opciones;
	}

	public UserRole(Integer userRoleId, String role, User user) {
		super();
		this.userRoleId = userRoleId;
		this.role = role;
		this.user = user;
	}

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Opcion> getOpciones() {
		return opciones;
	}

	public void setOpciones(Set<Opcion> opciones) {
		this.opciones = opciones;
	}
	
	
	
	
}
