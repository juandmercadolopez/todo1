package com.tecso.demo.service;

import com.tecso.demo.entity.Cliente;
import com.tecso.demo.entity.User;
import com.tecso.demo.model.ClienteModel;
import com.tecso.demo.model.RestorePasswordP1;
import com.tecso.demo.model.UsuarioCliente;

public interface ClienteService {
	
	public abstract Cliente addCliente(UsuarioCliente usuarioCliente, User user) throws Exception;
	
	public boolean getClienteByDocumentoAndTipoDocumento(RestorePasswordP1 rp1) throws Exception;
	
	public ClienteModel getClienteByUsername(String username);

}
