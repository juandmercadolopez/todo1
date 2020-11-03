package com.tecso.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente{

	@Id
	@Column(name="documento", length = 10, nullable = false)
	private String documento;
	@Column(name="tipo_documento", length = 3, nullable = false)
	private String tipoDocumento;
	@Column(name="nombre", length = 45, nullable = false)
	private String nombre;
	@Column(name="apellidos", length = 45, nullable = false)
	private String apellidos;
	@Column(name="fecha_nacimiento", nullable = false)
	private Date fechaNacimiento;
	@Column(name="correo_electronico", length = 45, nullable = false)
	private String correoElectronico;
	@Column(name="saldo", nullable = false)
	private int saldo;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="users_username", referencedColumnName = "username", nullable = false)
	private User user;

	public Cliente() {
	}

	public Cliente(String documento, String tipoDocumento, String nombre, String apellidos, Date fechaNacimiento,
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
