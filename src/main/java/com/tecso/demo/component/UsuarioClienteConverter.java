package com.tecso.demo.component;

import com.tecso.demo.entity.Cliente;
import com.tecso.demo.entity.User;
import com.tecso.demo.model.UsuarioCliente;

public class UsuarioClienteConverter {

	public static User convertUsuarioClienteModelToUser(UsuarioCliente usuarioCliente) {

		User user = new User(usuarioCliente.getUsuario(), usuarioCliente.getPassword(), true);

		return user;

	}

	public static Cliente convertUsuarioClienteModelToCliente(UsuarioCliente usuarioCliente, User user) {

		Cliente cliente = new Cliente(usuarioCliente.getDocumento(), usuarioCliente.getTipoDocumento(),
				usuarioCliente.getNombre(), usuarioCliente.getApellidos(), usuarioCliente.getFechaNacimiento(),
				usuarioCliente.getCorreoElectronico(), 0, user);

		return cliente;

	}

}
