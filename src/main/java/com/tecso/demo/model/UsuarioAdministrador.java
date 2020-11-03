package com.tecso.demo.model;

import com.tecso.demo.crypt.Encryption;

public class UsuarioAdministrador {
	
	private String documento;
	private String tipoDocumento;
	private String nombre;
	private String apellidos;
	private String usuario;
	private String password;
	private String passwordConfirm;
	
	public UsuarioAdministrador(){
		
	}
	
	public UsuarioAdministrador(String documento, String tipoDocumento, String nombre, String apellidos, String usuario,
			String password) {
		super();
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.password = password;
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
		this.password = Encryption.encrypt(password);
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}	

}
