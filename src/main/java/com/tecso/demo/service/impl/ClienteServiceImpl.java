package com.tecso.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tecso.demo.component.ClienteConverter;
import com.tecso.demo.component.UsuarioClienteConverter;
import com.tecso.demo.entity.Cliente;
import com.tecso.demo.entity.User;
import com.tecso.demo.model.ClienteModel;
import com.tecso.demo.model.RestorePasswordP1;
import com.tecso.demo.model.UsuarioCliente;
import com.tecso.demo.repository.ClienteRepository;
import com.tecso.demo.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	@Qualifier("clienteRepository")
	private ClienteRepository clienteRepository;

	@Override
	public Cliente addCliente(UsuarioCliente usuarioCliente, User user) throws Exception{
		Cliente cliente = UsuarioClienteConverter.convertUsuarioClienteModelToCliente(usuarioCliente, user);
		cliente.setSaldo(500000);
		cliente = clienteRepository.save(cliente);		
		
		return cliente;
	}

	@Override
	public boolean getClienteByDocumentoAndTipoDocumento(RestorePasswordP1 rp1)
			throws Exception {
		boolean coincide = false;	
		Cliente cliente = clienteRepository.findByDocumentoAndTipoDocumento(rp1.getDocumento(), rp1.getTipoDocumento());
		
		if(null != cliente) {
			if(cliente.getUser().getUsername().equals(rp1.getUsuario())) {
				coincide = true;	
			}
		}	
		
		return coincide;
	}

	@Override
	public ClienteModel getClienteByUsername(String username) {
		User user = new User(username, "", true);
		
		ClienteModel clienteModel = ClienteConverter.convertClienteEntityToModel(clienteRepository.findByUser(user));
		
		return clienteModel;
	}

}
