package com.tecso.demo.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tecso.demo.entity.Categoria;
import com.tecso.demo.model.CategoriaModel;

@Component
public class CategoriaConverter {

	public static CategoriaModel convertCategoriaEntityToModel(Categoria categoria) {

		CategoriaModel categoriaModel = new CategoriaModel(categoria.getIdCategoria(), categoria.getNombre());

		return categoriaModel;

	}

	public static Categoria convertCategoriaModelToEntity(CategoriaModel categoriaModel) {

		Categoria categoria = new Categoria(categoriaModel.getIdCategoria(), categoriaModel.getNombre());

		return categoria;

	}

	public List<CategoriaModel> convertListCategoriaEntityToListModel(List<Categoria> categoria) {

		List<CategoriaModel> listCategoriaModel = null;

		if (categoria.size() > 0) {
			listCategoriaModel = new ArrayList<CategoriaModel>();
			for (int i = 0; i < categoria.size(); i++) {
				CategoriaModel categoriaModel = new CategoriaModel(categoria.get(i).getIdCategoria(), categoria.get(i).getNombre());
				listCategoriaModel.add(categoriaModel);
			}
		}
		
		return listCategoriaModel;

	}	


}
