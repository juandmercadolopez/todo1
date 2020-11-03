package com.tecso.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="opciones")
public class Opcion {
	
	@Id
	@GeneratedValue
	@Column(name="id_opcion", unique = true, nullable = false)
	private int idOpcion;
	@Column(name="nombre", nullable = false, length = 45)
	private String nombre;
	@Column(name="vista", nullable = false, length = 45)
	private String vista;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_rol_user_rol_id", referencedColumnName = "user_role_id", nullable = false)
	private UserRole userRol;
	
	public Opcion() {
		
	}
	
	public Opcion(int idOpcion, String nombre, String vista, UserRole userRol) {
		super();
		this.idOpcion = idOpcion;
		this.nombre = nombre;
		this.vista = vista;
		this.userRol = userRol;
	}
	
	public int getId() {
		return idOpcion;
	}
	public void setId(int idOpcion) {
		this.idOpcion = idOpcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getVista() {
		return vista;
	}
	public void setVista(String vista) {
		this.vista = vista;
	}
	public UserRole getUserRol() {
		return userRol;
	}
	public void setUserRol(UserRole userRol) {
		this.userRol = userRol;
	}
	
	

}
