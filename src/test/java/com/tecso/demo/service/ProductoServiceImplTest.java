package com.tecso.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tecso.demo.model.CategoriaModel;
import com.tecso.demo.model.ProductoModel;

public class ProductoServiceImplTest {
	
	
	@Autowired
	private ProductoService productoService;
	
	ProductoModel productoModel = null;
	CategoriaModel categoriaModel = null;
	
	@BeforeAll
	public void setUp() {
		categoriaModel = new CategoriaModel();
		categoriaModel.setIdCategoria(1);
		categoriaModel.setNombre("Calzado_Test");
		productoModel = new ProductoModel();
		productoModel.setIdProducto(1);
		productoModel.setNombre("Producto_Test");
		productoModel.setDescripcion("Producto de prueba");
		productoModel.setCantidad(3);
		productoModel.setPrecio(100000);
		productoModel.setCategoria(categoriaModel);		
		productoModel.setCodigoBarra("234234235");
	}
	
	@Test
	public void addCategoriaAssertTest() {
		try {
			assertEquals(true, productoService.addProducto(productoModel));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void updateCategoriaAssertTest() {
		try {
			assertEquals(1, productoService.updateProducto(productoModel));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void getCategoriaByIdAssertTest() {
		try {
			assertEquals(productoModel, productoService.getProductoById(productoModel.getIdProducto()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
