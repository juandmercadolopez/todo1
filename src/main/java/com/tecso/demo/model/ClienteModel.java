package com.tecso.demo.model;

import java.util.Date;

import com.tecso.demo.entity.User;

public class ClienteModel{

	private String documento;
	private String tipoDocumento;
	private String nombre;
	private String apellidos;
	private Date fechaNacimiento;
	private String correoElectronico;
	private int saldo;
	private User user;

	public ClienteModel() {
	}

	public ClienteModel(String documento, String tipoDocumento, String nombre, String apellidos, Date fechaNacimiento,
			String correoElectronico, int saldo, User user) {
		super();
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.correoElectronico = correoElectronico;
		this.saldo = saldo;
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	

}
