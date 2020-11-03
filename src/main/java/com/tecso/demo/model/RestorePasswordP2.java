package com.tecso.demo.model;

public class RestorePasswordP2 {
	
	private String usuario;
	private String password;
	private String passwordConfirm;
	
	public RestorePasswordP2() {
		
	}	
	
	public RestorePasswordP2(String usuario, String password, String passwordConfirm) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
	}

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	

}
