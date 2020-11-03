package com.tecso.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "administradores")
public class Administrador{

	@Id
	@Column(name="documento", length = 10, nullable = false)
	private String documento;
	@Column(name="tipo_documento", length = 3, nullable = false)
	private String tipoDocumento;
	@Column(name="nombre", length = 45, nullable = false)
	private String nombre;
	@Column(name="apellidos", length = 45, nullable = false)
	private String apellidos;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="users_username", referencedColumnName = "username", nullable = false)
	private User user;

	public Administrador() {
	
	}
	
	public Administrador(String documento, String tipoDocumento, String nombre, String apellidos, User user) {
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
