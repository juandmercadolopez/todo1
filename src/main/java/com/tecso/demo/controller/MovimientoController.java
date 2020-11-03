package com.tecso.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tecso.demo.model.MovimientoModel;
import com.tecso.demo.service.MovimientoService;

@Controller
@RequestMapping("/movimiento")
public class MovimientoController {


	@Autowired
	private MovimientoService movimientoService;

	@GetMapping("/compra")
	public String getCompraView(@RequestParam(name = "doc", required = true) String doc,
			@RequestParam(name = "categoria", required = true) String categoria,
			@RequestParam(name = "producto", required = true) String producto,
			@RequestParam(name = "precio", required = true) int precio,
			@RequestParam(name = "idProducto", required = true) int idProducto, Model model) {


		MovimientoModel movimientoModel = new MovimientoModel();
		movimientoModel.setDocumento(doc);
		movimientoModel.setCategoria(categoria);
		movimientoModel.setProducto(producto);
		movimientoModel.setPrecio(precio);
		movimientoModel.setIdProducto(idProducto);

		model.addAttribute("movimientoModel", movimientoModel);

		return "compra";

	}

	@PostMapping("/comprar")
	public String comprar(@ModelAttribute(name = "movimientoModel") MovimientoModel movimientoModel,
			Model model) {
		boolean saved = false;

		try {

			saved = movimientoService.add(movimientoModel);

			if (saved) {
				model.addAttribute("result", 1);
			} else {
				model.addAttribute("result", 0);
			}

		} catch (Exception e) {
			model.addAttribute("result", 2);
		}

		return "compra";
	}

}
