package com.tecso.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecso.demo.component.ProductoConverter;
import com.tecso.demo.component.CategoriaConverter;
import com.tecso.demo.entity.Producto;
import com.tecso.demo.entity.Categoria;
import com.tecso.demo.model.ProductoModel;
import com.tecso.demo.repository.ProductoRepository;
import com.tecso.demo.service.ProductoService;
import com.tecso.demo.util.Utils;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private ProductoConverter productoConverter;

	@Override
	public boolean addProducto(ProductoModel productoModel) throws Exception {

		Producto producto = new Producto(productoModel.getNombre(), productoModel.getDescripcion(),
				productoModel.getPrecio(), productoModel.getCantidad(), Utils.generateRandomNumer(),
				CategoriaConverter.convertCategoriaModelToEntity(productoModel.getCategoria()));

		productoRepository.save(producto);

		return true;

	}

	@Override
	public int updateProducto(ProductoModel productoModel) throws Exception {

		return productoRepository.updateProducto(productoModel.getIdProducto(), productoModel.getNombre(),
				productoModel.getDescripcion(), productoModel.getPrecio(), productoModel.getCantidad(),
				CategoriaConverter.convertCategoriaModelToEntity(productoModel.getCategoria()));
	}

	@Override
	public boolean deleteProducto(int id) throws Exception {
		Producto producto = new Producto();
		producto.setIdProducto(id);
		productoRepository.delete(producto);
		return true;
	}

	@Override
	public List<ProductoModel> listProductos() throws Exception {
		List<ProductoModel> listProductoModel = productoConverter
				.convertListProductoEntityToListModel(productoRepository.findAll());
		return listProductoModel;

	}
	
	@Override
	public ProductoModel getProductoById(int id) {
		ProductoModel productoModel = ProductoConverter.convertProductoEntityToModel(productoRepository.findByIdProducto(id));
		return productoModel;
	}
	
	@Override
	public List<ProductoModel> getProductosByIdCategoria(int id) {
		Categoria categoria = new Categoria();
		categoria.setIdCategoria(id);
		List<ProductoModel> listProductosModel = productoConverter.convertListProductoEntityToListModel(productoRepository.findByCategoria(categoria));
		return listProductosModel;
	}

}
