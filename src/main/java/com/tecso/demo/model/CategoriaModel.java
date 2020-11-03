package com.tecso.demo.model;

import java.util.HashSet;
import java.util.Set;

import com.tecso.demo.entity.Producto;

public class CategoriaModel {
	
	private int idCategoria;
	private String nombre;
	private Set<Producto> productos = new HashSet<Producto>();
	
	public CategoriaModel() {
		
	}
	
	public CategoriaModel(int idCategoria, String nombre) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
	}	
	
	public CategoriaModel(int idCategoria, String nombre, Set<Producto> productos) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.productos = productos;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProducto(Set<Producto> productos) {
		this.productos = productos;
	}

}
