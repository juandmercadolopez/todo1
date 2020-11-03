package com.tecso.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecso.demo.component.CategoriaConverter;
import com.tecso.demo.entity.Categoria;
import com.tecso.demo.model.CategoriaModel;
import com.tecso.demo.repository.CategoriaRepository;
import com.tecso.demo.service.CategoriaService;


@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private CategoriaConverter categoriaConverter;

	@Override
	public boolean addCategoria(CategoriaModel categoriaModel) throws Exception {

		Categoria categoria = new Categoria(categoriaModel.getNombre());

		categoriaRepository.save(categoria);

		return true;

	}

	@Override
	public int updateCategoria(CategoriaModel categoriaModel) throws Exception {

		return categoriaRepository.updateCategoria(categoriaModel.getIdCategoria(), categoriaModel.getNombre());
	}

	@Override
	public boolean deleteCategoria(int id) throws Exception {
		Categoria categoria = new Categoria();
		categoria.setIdCategoria(id);
		categoriaRepository.deleteProductosCategoria(categoria);
		categoriaRepository.delete(categoria);		
		return true;
	}

	@Override
	public List<CategoriaModel> listCategorias() throws Exception {
		List<CategoriaModel> listCategoriaModel = categoriaConverter
				.convertListCategoriaEntityToListModel(categoriaRepository.findAll());
		return listCategoriaModel;

	}

	@Override
	public CategoriaModel getCategoriaById(int id) {
		CategoriaModel categoriaModel = CategoriaConverter.convertCategoriaEntityToModel(categoriaRepository.findByIdCategoria(id));
		return categoriaModel;
	}

}
