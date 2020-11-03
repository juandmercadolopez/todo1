package com.tecso.demo.service;

import com.tecso.demo.entity.User;
import com.tecso.demo.model.UsuarioAdministrador;
import com.tecso.demo.model.UsuarioCliente;

public interface UserService {
	
	public abstract User addUser(User user) throws Exception;

	public boolean registrarUsuario(UsuarioCliente usuarioCliente) throws Exception;

	public boolean registrarUsuarioAdmin(UsuarioAdministrador usuarioAdministrador) throws Exception;

	public User updateUser(String usuario, String password);

}
