package com.tecso.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name="username", unique = true, nullable = false, length = 45)
	private String username;
	@Column(name="password", nullable = false, length = 60)
	private String password;
	@Column(name="enabled", nullable = false)
	private boolean enabled;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<UserRole> userRoles = new HashSet<UserRole>();
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<Cliente> clientes = new HashSet<Cliente>();

	public User() {
	}

	public User(String username, String password, boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}
	
	
	public User(String username, String password, boolean enabled, Set<UserRole> userRoles, Set<Cliente> clientes) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRoles = userRoles;
		this.clientes = clientes;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}	

}
