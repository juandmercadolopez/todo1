package com.tecso.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tecso.demo.crypt.Encryption;
import com.tecso.demo.model.RestorePasswordP2;
import com.tecso.demo.service.UserService;

@Controller
@RequestMapping("/perfil")
public class PerfilController {
	
	@Autowired
	private UserService userService;
	

	@PostMapping("/cambiarPassword")
	public String restorePasswordP2(@ModelAttribute (name = "restorePasswordP2") RestorePasswordP2 restorePasswordP2, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		try {
						
		if(restorePasswordP2.getPassword().equals(restorePasswordP2.getPasswordConfirm())) {
			userService.updateUser(auth.getName(), Encryption.encrypt(restorePasswordP2.getPassword()));
			model.addAttribute("actualizado", 1);
			return "config";
		}else {
			model.addAttribute("actualizado", 0);
			return "config";
		}
			
		} catch (Exception e) {
			model.addAttribute("actualizado", 2);
			e.printStackTrace();
			return "config";
		}
				
	}

}
