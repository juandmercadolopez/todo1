package com.tecso.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categorias")
public class Categoria {
	@Id
	@GeneratedValue
	@Column(name="id_categoria", unique = true, nullable = false)
	private int idCategoria;
	@Column(name="nombre", unique = true, nullable = false, length = 45)
	private String nombre;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "categoria")
	private Set<Producto> productos = new HashSet<Producto>();
	
	
	public Categoria() {
		
	}
	
	public Categoria(int idCategoria, String nombre) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
	}
	
	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
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

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	
}
