package com.tecso.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tecso.demo.entity.Administrador;
import com.tecso.demo.entity.User;

@Repository("administradorRepository")
public interface AdministradorRepository extends JpaRepository<Administrador, Serializable>{
	
	public abstract Administrador findByDocumentoAndTipoDocumento(String documento, String tipoDocumento);
	
	public abstract Administrador findByUser(User user);

}
