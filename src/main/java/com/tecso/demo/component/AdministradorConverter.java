package com.tecso.demo.component;

import com.tecso.demo.entity.Administrador;
import com.tecso.demo.model.AdministradorModel;

public class AdministradorConverter {
	
	public static AdministradorModel convertAdministradorEntityToModel(Administrador administrador) {
		AdministradorModel administradorModel = new AdministradorModel(administrador.getDocumento(), administrador.getTipoDocumento(),
				administrador.getNombre(), administrador.getApellidos(), administrador.getUser());
		return administradorModel;
	}

}
