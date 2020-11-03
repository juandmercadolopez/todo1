package com.tecso.demo.model;

import java.util.List;

public class ProductoModel {
	
	private int idProducto;
	private String nombre;
	private String descripcion;
	private int precio;
	private int cantidad;
	private String codigoBarra;
	private CategoriaModel categoria;
	private List<CategoriaModel> categorias;
	
	public ProductoModel() {
		
	}
	
	public ProductoModel(int idProducto, String nombre, String descripcion, int precio, int cantidad, String codigoBarra,
			CategoriaModel categoria) {
		super();
		this.idProducto = idProducto;
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

	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}

	public List<CategoriaModel> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<CategoriaModel> categorias) {
		this.categorias = categorias;
	}

	
	

}
