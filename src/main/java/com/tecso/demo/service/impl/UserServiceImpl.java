package com.tecso.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tecso.demo.component.UsuarioAdministradorConverter;
import com.tecso.demo.component.UsuarioClienteConverter;
import com.tecso.demo.entity.User;
import com.tecso.demo.model.UsuarioAdministrador;
import com.tecso.demo.model.UsuarioCliente;
import com.tecso.demo.repository.UserRepository;
import com.tecso.demo.service.AdministradorService;
import com.tecso.demo.service.ClienteService;
import com.tecso.demo.service.UserRolService;
import com.tecso.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Autowired
	private UserRolService userRolService;

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private AdministradorService administradorService;

	@Override
	public User addUser(User user) {

		return userRepository.save(user);
	}
	
	@Override
	public User updateUser(String usuario, String password) {
		User user = new User(usuario, password, true);
		return userRepository.save(user);
	}

	@Override
	public boolean registrarUsuario(UsuarioCliente usuarioCliente) throws Exception {
		boolean registro = false;
		User user;
		
		if (null != usuarioCliente) {
			
			user = addUser(UsuarioClienteConverter.convertUsuarioClienteModelToUser(usuarioCliente));
			
			userRolService.addUserRole("USER_ROLE", user);
			
			clienteService.addCliente(usuarioCliente, user);
			
			registro = true;

		}

		return registro;

	}
	
	@Override
	public boolean registrarUsuarioAdmin(UsuarioAdministrador usuarioAdministrador) throws Exception {
		boolean registro = false;
		User user;
		
		if (null != usuarioAdministrador) {
			
			user = addUser(UsuarioAdministradorConverter.convertAdministradorModelToUser(usuarioAdministrador));
			
			userRolService.addUserRole("ADMIN_ROLE", user);

			administradorService.addAdministrador(usuarioAdministrador, user);
			
			registro = true;

		}

		return registro;

	}

}
