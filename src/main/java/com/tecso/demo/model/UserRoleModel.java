package com.tecso.demo.model;

public class UserRoleModel {
	
	private String role;
	private String usuario;
	private boolean enabled;
	
	public UserRoleModel() {
		
	}
	
	public UserRoleModel(String role, String usuario, boolean enabled) {
		super();
		this.role = role;
		this.usuario = usuario;
		this.enabled = enabled;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}	
	

}
