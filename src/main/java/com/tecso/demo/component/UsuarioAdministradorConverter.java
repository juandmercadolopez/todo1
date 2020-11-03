package com.tecso.demo.component;

import com.tecso.demo.entity.Administrador;
import com.tecso.demo.entity.User;
import com.tecso.demo.model.UsuarioAdministrador;


public class UsuarioAdministradorConverter {
	
	public static User convertAdministradorModelToUser(UsuarioAdministrador usuarioAdministrador) {

		User user = new User(usuarioAdministrador.getUsuario(), usuarioAdministrador.getPassword(), true);

		return user;

	}

	public static Administrador convertUsuarioAdministradorModelToAdministrador(UsuarioAdministrador usuarioAdministrador, User user) {

		Administrador admin = new Administrador(usuarioAdministrador.getDocumento(), usuarioAdministrador.getTipoDocumento(), usuarioAdministrador.getNombre(), usuarioAdministrador.getApellidos(), user);

		return admin;

	}

}
