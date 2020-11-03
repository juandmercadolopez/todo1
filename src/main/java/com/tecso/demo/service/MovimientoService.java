package com.tecso.demo.service;

import java.util.List;

import com.tecso.demo.model.MovimientoModel;

public interface MovimientoService {

	List<MovimientoModel> listMovimientos();
	
	boolean add(MovimientoModel movimientoModel) throws Exception;

}
