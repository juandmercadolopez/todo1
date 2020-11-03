package com.tecso.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tecso.demo.constant.ViewConstant;
import com.tecso.demo.model.AdministradorModel;
import com.tecso.demo.model.ClienteModel;
import com.tecso.demo.model.UserRoleModel;
import com.tecso.demo.service.AdministradorService;
import com.tecso.demo.service.CategoriaService;
import com.tecso.demo.service.ClienteService;
import com.tecso.demo.service.UserRolService;

@Controller
public class LoginController {
	
	@Autowired
	private UserRolService userRoleService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private AdministradorService administradorService;
	
	@Autowired
	private HttpServletRequest request;
	
	
	@GetMapping("/login")
	public String showLoginForm(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return  ViewConstant.LOGIN;
	}

	// /loginsuccess o / se usaran para entrar en este metodo
	@GetMapping({"/loginsuccess", "/"})	
	public String loginCheck(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		HttpSession httpSession = request.getSession();
		UserRoleModel userRoleModel = null;
		ClienteModel clienteModel = null;
		AdministradorModel administradorModel = null;
		
		if (null != auth && auth.isAuthenticated()) {
			try {
				userRoleModel = userRoleService.getByUsername(auth.getName());	
				httpSession.setAttribute("usuario", userRoleModel.getUsuario());
				httpSession.setAttribute("rol", userRoleModel.getRole());
	
				if(userRoleModel.getRole().equals("ADMIN_ROLE")) {	
					administradorModel = administradorService.getAdministradorByUsername(auth.getName());
					httpSession.setAttribute("administradorModel", administradorModel);
				}else {
					clienteModel = clienteService.getClienteByUsername(auth.getName());
					httpSession.setAttribute("clienteModel", clienteModel);
				}				
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		if(userRoleModel.getRole().equals("ADMIN_ROLE")) {
			return "index2";
		}else {
			try {
				model.addAttribute("listCategorias", categoriaService.listCategorias());
			} catch (Exception e) {
				model.addAttribute("result", 0);
				e.printStackTrace();
				return "index";
			}
			return "index";
		}			
	
	}

}
