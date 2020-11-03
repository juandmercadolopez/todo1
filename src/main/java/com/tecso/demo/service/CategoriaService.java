package com.tecso.demo.service;

import java.util.List;

import com.tecso.demo.model.CategoriaModel;

public interface CategoriaService {

	int updateCategoria(CategoriaModel categoriaModel) throws Exception;

	boolean addCategoria(CategoriaModel categoriaModel) throws Exception;

	List<CategoriaModel> listCategorias() throws Exception;
	
	CategoriaModel getCategoriaById(int id);

	boolean deleteCategoria(int id) throws Exception;

}
