package com.tecso.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tecso.demo.model.CategoriaModel;


public class CategoriaServiceImplTest {
	
	@Autowired
	private CategoriaService categoriaService;
	
	CategoriaModel categoriaModel = null;
	
	@BeforeAll
	public void setUp() {
		categoriaModel = new CategoriaModel();
		categoriaModel.setIdCategoria(1);
		categoriaModel.setNombre("Calzado_Test");		
	}
	
	@Test
	public void addCategoriaAssertTest() {
		try {
			assertEquals(true, categoriaService.addCategoria(categoriaModel));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void updateCategoriaAssertTest() {
		try {
			assertEquals(1, categoriaService.updateCategoria(categoriaModel));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* Se comenta para no eliminar data de la categoria con id inicialziado arriba
	 * @Test public void deleteCategoriaAssertTest() { try { assertEquals(true,
	 * categoriaService.deleteCategoria(categoriaModel.getIdCategoria())); } catch
	 * (Exception e) { e.printStackTrace(); } }
	 */
	
	@Test
	public void getCategoriaByIdAssertTest() {
		try {
			assertEquals(categoriaModel, categoriaService.getCategoriaById(categoriaModel.getIdCategoria()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
