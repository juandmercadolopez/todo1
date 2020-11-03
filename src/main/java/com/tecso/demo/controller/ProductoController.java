package com.tecso.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tecso.demo.model.MovimientoModel;
import com.tecso.demo.model.ProductoModel;
import com.tecso.demo.service.CategoriaService;
import com.tecso.demo.service.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@Autowired
	private CategoriaService categoriaService;

	
	@GetMapping("/productos")
	public String getProductosView(Model model) {

		try {
			model.addAttribute("productos", productoService.listProductos());
		} catch (Exception e) {
			model.addAttribute("result", 0);
			e.printStackTrace();
			return "productos";
		}
		return "productos";
	}

	@GetMapping("/crear_producto")
	public String getCrearProductosView(Model model, @RequestParam(name = "id", required = false) Integer id) {
		ProductoModel productoModel = null;
		
		if(id != null && id != 0) {
			productoModel = productoService.getProductoById(id);
		}else {
			productoModel = new ProductoModel();
		}		
		try {
			model.addAttribute("listCategorias", categoriaService.listCategorias());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		model.addAttribute("productoModel", productoModel);
		return "crear_producto";
	}

	@GetMapping("/actualizar_producto")
	public String getActualizarProductosView(Model model) {

		return "actualizar_producto";
	}
	
	@PostMapping("/crear")
	public String crearProducto(@ModelAttribute(name = "productoModel") ProductoModel productoModel, Model model) {

		try {
			if(productoModel.getIdProducto() > 0) {
				productoService.updateProducto(productoModel);
			}else {
				productoService.addProducto(productoModel);
			}
			model.addAttribute("listCategorias", categoriaService.listCategorias());
			model.addAttribute("result", 1);
		} catch (Exception e) {
			model.addAttribute("result", 0);
			e.printStackTrace();			
			return "crear_producto";	
		}

		return "crear_producto";
	}
	
	@GetMapping("/eliminar")
	public String removeProducto(@RequestParam(name = "id", required = true) int id, Model model) {
		try {
			productoService.deleteProducto(id);
		} catch (Exception e) {		
			e.printStackTrace();
			model.addAttribute("result", 0);			
			return "productos";
		}
		
		try {
			model.addAttribute("productos", productoService.listProductos());
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("result", 2);
			return "productos";
		}
		model.addAttribute("result", 1);
		return "productos";
	}
	

	@GetMapping("/productosbycategoria")
	public String getCategoriaProductosView(@RequestParam(name = "id", required = true) int id, Model model) {

		MovimientoModel movimientoModel = new MovimientoModel();
		
		try {
			
			List<ProductoModel> listProductos = productoService.getProductosByIdCategoria(id);
			
			if(listProductos.size() > 0) {
				model.addAttribute("listProductos", listProductos);
				model.addAttribute("movimientoModel", movimientoModel);
				model.addAttribute("idProducto", 0);
				model.addAttribute("result", 1);
			}else {
				model.addAttribute("result", 0);
			}			
			
		}catch (Exception e) {
			model.addAttribute("result", 0);
			return "productos_categoria";
		}		

		return "productos_categoria";
	}

}
