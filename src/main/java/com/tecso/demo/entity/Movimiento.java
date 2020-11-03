package com.tecso.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movimientos")
public class Movimiento {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="documento")
	private String documento;
	@Column(name="categoria")
	private String categoria;
	@Column(name="idProducto")
	private int idProducto;
	@Column(name="producto")
	private String producto;
	@Column(name="precio")
	private int precio;
	@Column(name="direccion")
	private String direccion;
	
	public Movimiento() {
		
	}

	public Movimiento(int id, String documento, String categoria, int idProducto, String producto, int precio,
			String direccion) {
		super();
		this.id = id;
		this.documento = documento;
		this.categoria = categoria;
		this.idProducto = idProducto;
		this.producto = producto;
		this.precio = precio;
		this.direccion = direccion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	

}
