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
@Table(name="productos")
public class Producto {

	@Id
	@GeneratedValue
	@Column(name="id_producto", unique = true, nullable = false)
	private int idProducto;
	@Column(name="nombre", nullable = false, length = 45)
	private String nombre;
	@Column(name="descripcion", nullable = false, length = 200)
	private String descripcion;
	@Column(name="precio", nullable = false)
	private int precio;
	@Column(name="cantidad", nullable = false)
	private int cantidad;
	@Column(name="codigo_barra", nullable = false, length = 10)
	private String codigoBarra;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="categoria_id_categoria", referencedColumnName = "id_categoria", nullable = false)
	private Categoria categoria;
	
	public Producto() {
		
	}
	
	public Producto(int idProducto, String nombre, String descripcion, int precio, int cantidad, String codigoBarra,
			Categoria categoria) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
		this.codigoBarra = codigoBarra;
		this.categoria = categoria;
	}
	
	public Producto(String nombre, String descripcion, int precio, int cantidad, String codigoBarra,
			Categoria categoria) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
		this.codigoBarra = codigoBarra;
		this.categoria = categoria;
	}
	
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getCodigoBarra() {
		return codigoBarra;
	}
	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}	

}
