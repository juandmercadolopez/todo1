package com.tecso.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tecso.demo.component.AdministradorConverter;
import com.tecso.demo.component.UsuarioAdministradorConverter;
import com.tecso.demo.entity.Administrador;
import com.tecso.demo.entity.User;
import com.tecso.demo.model.AdministradorModel;
import com.tecso.demo.model.RestorePasswordP1;
import com.tecso.demo.model.UsuarioAdministrador;
import com.tecso.demo.repository.AdministradorRepository;
import com.tecso.demo.service.AdministradorService;

@Service
public class AdministradorServiceImpl implements AdministradorService {

	@Autowired
	@Qualifier("administradorRepository")
	private AdministradorRepository administradorRepository;

	@Override
	public Administrador addAdministrador(UsuarioAdministrador usuarioAdministrador, User user) throws Exception {

		Administrador administrador = administradorRepository.save(UsuarioAdministradorConverter
				.convertUsuarioAdministradorModelToAdministrador(usuarioAdministrador, user));

		return administrador;
	}

	@Override
	public boolean getAdministradorByDocumentoAndTipoDocumento(RestorePasswordP1 rp1) throws Exception {
		boolean coincide = false;
		Administrador administrador = administradorRepository.findByDocumentoAndTipoDocumento(rp1.getDocumento(),
				rp1.getTipoDocumento());

		if (null != administrador) {

			if (administrador.getUser().getUsername().equals(rp1.getUsuario())) {
				coincide = true;
			}

		}

		return coincide;
	}

	@Override
	public AdministradorModel getAdministradorByUsername(String username) {
		User user = new User(username, "", true);
		
		AdministradorModel administradorModel = AdministradorConverter.convertAdministradorEntityToModel(administradorRepository.findByUser(user));
		
		return administradorModel;
	}

}
