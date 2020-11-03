package com.tecso.demo.repository;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tecso.demo.entity.Categoria;

@Repository("categoriaRepository")
public interface CategoriaRepository extends JpaRepository<Categoria, Serializable>{
	
	@Transactional
	@Modifying
    @Query("UPDATE Categoria c SET c.nombre = :nombre WHERE c.idCategoria = :idCategoria")
    public int updateCategoria(@Param("idCategoria") int idCategoria, @Param("nombre") String nombre);
	
	@Transactional
	@Modifying
    @Query("delete Producto p WHERE p.categoria = :idCategoria")
    public int deleteProductosCategoria(@Param("idCategoria") Categoria idCategoria);
	
	public abstract Categoria findByIdCategoria(Integer id);
	
	
	
}
