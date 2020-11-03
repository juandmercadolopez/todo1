package com.tecso.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tecso.demo.crypt.Encryption;
import com.tecso.demo.model.RestorePasswordP1;
import com.tecso.demo.model.RestorePasswordP2;
import com.tecso.demo.model.UsuarioAdministrador;
import com.tecso.demo.model.UsuarioCliente;
import com.tecso.demo.service.AdministradorService;
import com.tecso.demo.service.ClienteService;
import com.tecso.demo.service.UserService;

@Controller
@RequestMapping("/registro")
public class RegistroController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AdministradorService administradorService;
	
	@Autowired
	private ClienteService clienteService;

	@PostMapping("/cliente")
	public String registrarUsuario(@ModelAttribute(name = "usuarioCliente") UsuarioCliente usuarioCliente,
			Model model) {

		boolean registro = false;

		try {
			registro = userService.registrarUsuario(usuarioCliente);

			if (registro) {
				model.addAttribute("registro", 1);
				return "customer_signup";
			} else {
				model.addAttribute("registro", 0);
				return "customer_signup";
			}

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("registro", 2);
			return "customer_signup";
		}

	}

	@PostMapping("/administrador")
	public String registrarAdministrador(
			@ModelAttribute(name = "usuarioAdministrador") UsuarioAdministrador usuarioAdministrador, Model model) {

		boolean registro = false;

		try {
			registro = userService.registrarUsuarioAdmin(usuarioAdministrador);

			if (registro) {
				model.addAttribute("registro", 1);
				return "admin_signup";
			} else {
				model.addAttribute("registro", 0);
				return "admin_signup";
			}

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("registro", 2);
			return "admin_signup";
		}

	}
	
	@PostMapping("/paso1/restorePassword")
	public String restorePasswordP1(@ModelAttribute (name = "restorePasswordP1") RestorePasswordP1 restorePasswordP1, Model model) {
		RestorePasswordP2 restorePasswordP2;
		boolean cliente =  false;
		boolean admin = false;
		try {
			cliente = clienteService.getClienteByDocumentoAndTipoDocumento(restorePasswordP1);
			admin = administradorService.getAdministradorByDocumentoAndTipoDocumento(restorePasswordP1);
			
			if(cliente || admin) {
				restorePasswordP2 =  new RestorePasswordP2();
				model.addAttribute("coincide", 1);
				model.addAttribute("usuario", restorePasswordP1.getUsuario());				
				model.addAttribute("restorePasswordP2", restorePasswordP2);
				return "password_confirm";
			}else {
				model.addAttribute("coincide", 0);
				return "password_recovery";
			}
			
		} catch (Exception e) {
			model.addAttribute("coincide", 2);
			e.printStackTrace();
			return "password_recovery";
		}
				
	}
	
	@PostMapping("/paso2/restorePassword")
	public String restorePasswordP2(@ModelAttribute (name = "restorePasswordP2") RestorePasswordP2 restorePasswordP2, Model model) {
		
		try {
						
		if(restorePasswordP2.getPassword().equals(restorePasswordP2.getPasswordConfirm())) {
			userService.updateUser(restorePasswordP2.getUsuario(), Encryption.encrypt(restorePasswordP2.getPassword()));
			model.addAttribute("actualizado", 1);
			return "password_confirm";
		}else {
			model.addAttribute("actualizado", 0);
			return "password_confirm";
		}
			
		} catch (Exception e) {
			model.addAttribute("actualizado", 2);
			e.printStackTrace();
			return "password_confirm";
		}
				
	}
	

}
