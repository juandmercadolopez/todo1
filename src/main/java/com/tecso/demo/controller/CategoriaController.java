package com.tecso.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tecso.demo.model.CategoriaModel;
import com.tecso.demo.service.CategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	
	@GetMapping("/categorias")
	public String getCategoriasView(Model model) {
		
		try {
			model.addAttribute("categorias", categoriaService.listCategorias());
		} catch (Exception e) {
			model.addAttribute("result", 0);
			e.printStackTrace();
		}	

		return "categorias";
	}

	@GetMapping("/crear_categoria")
	public String getCrearcategoriasView(Model model, @RequestParam(name = "id", required = false) Integer id) {
		CategoriaModel categoriaModel = null;
		
		if(id != null && id != 0) {
			categoriaModel = categoriaService.getCategoriaById(id);
		}else {
			categoriaModel = new CategoriaModel();
		}		
		
		model.addAttribute("categoriaModel", categoriaModel);
		return "crear_categoria";
	}

	@GetMapping("/actualizar_categoria")
	public String getActualizarcategoriasView(Model model) {

		return "actualizar_categoria";
	}
	
	@PostMapping("/crear")
	public String crearCategoria(@ModelAttribute(name = "categoriaModel") CategoriaModel categoriaModel, Model model) {

		try {
			if(categoriaModel.getIdCategoria() > 0) {
				categoriaService.updateCategoria(categoriaModel);
			}else {
				categoriaService.addCategoria(categoriaModel);
			}
			
			model.addAttribute("result", 1);
		} catch (Exception e) {
			model.addAttribute("result", 0);
			e.printStackTrace();
			return "crear_categoria";	
		}

		return "crear_categoria";		
	}
	
	@GetMapping("/eliminar")
	public String removeCategoria(@RequestParam(name = "id", required = true) int id, Model model) {
		try {
			categoriaService.deleteCategoria(id);
		} catch (Exception e) {		
			e.printStackTrace();
			model.addAttribute("result", 0);			
			return "categorias";
		}
		
		try {
			model.addAttribute("categorias", categoriaService.listCategorias());
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("result", 2);
			return "categorias";
		}
		model.addAttribute("result", 1);
		return "categorias";
	}

}
