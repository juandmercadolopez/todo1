package com.tecso.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tecso.demo.model.MovimientoModel;

public class MovimientoServiceImplTest {

	@Autowired
	private MovimientoService movimientoService;

	MovimientoModel movimientoModel = null;

	@BeforeAll
	public void setUp() {
		movimientoModel = new MovimientoModel();
		movimientoModel.setCategoria("Calzado_Test");
		movimientoModel.setDireccion("Calle 13");
		movimientoModel.setDocumento("1140824853");
		movimientoModel.setIdProducto(1);
		movimientoModel.setPrecio(50000);	
	}
	
	@Test
	public void addMovimientoAssertTest() {
		try {
			assertEquals(true, movimientoService.add(movimientoModel));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
