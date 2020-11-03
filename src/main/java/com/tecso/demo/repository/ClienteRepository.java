package com.tecso.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tecso.demo.entity.Cliente;
import com.tecso.demo.entity.User;

@Repository("clienteRepository")
public interface ClienteRepository extends JpaRepository<Cliente, Serializable>{
	
	public abstract Cliente findByDocumentoAndTipoDocumento(String documento, String tipoDocumento);
	
	public abstract Cliente findByUser(User user);
	
	public abstract Cliente findByDocumento(String documento);
	
	

}
