package com.tecso.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tecso.demo.model.MovimientoModel;
import com.tecso.demo.model.RestorePasswordP1;
import com.tecso.demo.model.RestorePasswordP2;
import com.tecso.demo.model.UsuarioAdministrador;
import com.tecso.demo.model.UsuarioCliente;
import com.tecso.demo.service.MovimientoService;

@Controller
public class NavigationController {

	
	@Autowired
	private MovimientoService movimientoService;;


	@GetMapping("/admin_signup")
	public String getCreateAdminView(Model model) {
		UsuarioAdministrador usuarioAdministrador = new UsuarioAdministrador();
		model.addAttribute("usuarioAdministrador", usuarioAdministrador);
		return "admin_signup";
	}

	@GetMapping("/customer_signup")
	public String getCreateCustomerView(Model model) {
		UsuarioCliente usuarioCliente = new UsuarioCliente();
		model.addAttribute("usuarioCliente", usuarioCliente);
		return "customer_signup";
	}

	@GetMapping("/password_recovery")
	public String getRecoveryPasswordView(Model model) {
		RestorePasswordP1 restorePasswordP1 = new RestorePasswordP1();
		model.addAttribute("restorePasswordP1", restorePasswordP1);
		return "password_recovery";
	}

	@GetMapping("/index")
	public String getIndexView(Model model) {

		return "index";
	}

	@GetMapping("/index2")
	public String getIndex2View(Model model) {

		return "index2";
	}

	@GetMapping("/config")
	public String getConfigView(Model model) {
		RestorePasswordP2 restorePasswordP2 = new RestorePasswordP2();
		model.addAttribute("restorePasswordP2", restorePasswordP2);

		return "config";
	}

	@GetMapping("/perfil")
	public String getPerfilView(Model model) {

		return "perfil";
	}
	
	@GetMapping("/movimientos")
	public String getMovimientosView(Model model) {
		
		try {
			
			List<MovimientoModel> listMovimientos = movimientoService.listMovimientos();
			
			if(listMovimientos.size() > 0) {
				model.addAttribute("listMovimientos", listMovimientos);
				model.addAttribute("result", 1);
			}else {
				model.addAttribute("listMovimientos", listMovimientos);
				model.addAttribute("result", 0);
			}	
			
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("result", 2);
			return "movimientos";
		}
		
		
				
		return "movimientos";
	}

}
