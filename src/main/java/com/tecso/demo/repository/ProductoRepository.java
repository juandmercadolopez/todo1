package com.tecso.demo.repository;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tecso.demo.entity.Producto;
import com.tecso.demo.entity.Categoria;

@Repository("productoRepository")
public interface ProductoRepository extends JpaRepository<Producto, Serializable> {

	@Transactional
	@Modifying
	@Query("UPDATE Producto p SET p.nombre = :nombre, p.descripcion = :descripcion, p.precio = :precio, p.cantidad = :cantidad, "
			+ "p.categoria = :idCategoria WHERE p.idProducto = :idProducto")
	public int updateProducto(@Param("idProducto") int idProducto, @Param("nombre") String nombre,
			@Param("descripcion") String descripcion, @Param("precio") int precio, @Param("cantidad") int cantidad,
			@Param("idCategoria") Categoria idCategoria);
	
	public abstract Producto findByIdProducto(Integer id);
	
	public abstract List<Producto> findByCategoria(Categoria categoria);
	
	public abstract Producto findByIdProducto(int idProducto);
	
	
	
	
	
	

}
