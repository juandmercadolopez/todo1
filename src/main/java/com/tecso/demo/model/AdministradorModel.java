package com.tecso.demo.model;

import com.tecso.demo.entity.User;

public class AdministradorModel {

	private String documento;
	private String tipoDocumento;
	private String nombre;
	private String apellidos;
	private User user;
	
	public AdministradorModel() {
		
	}
	
	public AdministradorModel(String documento, String tipoDocumento, String nombre, String apellidos, User user) {
		super();
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.user = user;
	}
	
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
