package com.tecso.demo.component;

import com.tecso.demo.entity.Cliente;
import com.tecso.demo.model.ClienteModel;


public class ClienteConverter {

	public static ClienteModel convertClienteEntityToModel(Cliente cliente) {
		ClienteModel clienteModel = new ClienteModel(cliente.getDocumento(), cliente.getTipoDocumento(),
				cliente.getNombre(), cliente.getApellidos(), cliente.getFechaNacimiento(),
				cliente.getCorreoElectronico(), cliente.getSaldo(), cliente.getUser());
		return clienteModel;
	}

}
