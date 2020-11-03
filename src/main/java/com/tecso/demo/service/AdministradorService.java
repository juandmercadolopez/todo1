package com.tecso.demo.service;

import com.tecso.demo.entity.Administrador;
import com.tecso.demo.entity.User;
import com.tecso.demo.model.AdministradorModel;
import com.tecso.demo.model.RestorePasswordP1;
import com.tecso.demo.model.UsuarioAdministrador;

public interface AdministradorService {
	
		public abstract Administrador addAdministrador(UsuarioAdministrador usuarioAdministrador, User user) throws Exception;
		
		public boolean getAdministradorByDocumentoAndTipoDocumento(RestorePasswordP1 rp1) throws Exception;
		
		public AdministradorModel getAdministradorByUsername(String username);

}
