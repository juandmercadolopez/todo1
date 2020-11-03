package com.tecso.demo.service;

import java.util.List;

import com.tecso.demo.model.ProductoModel;

public interface ProductoService {

	boolean addProducto(ProductoModel productoModel) throws Exception;

	List<ProductoModel> listProductos() throws Exception;

	int updateProducto(ProductoModel productoModel) throws Exception;

	boolean deleteProducto(int id) throws Exception;

	ProductoModel getProductoById(int id);

	List<ProductoModel> getProductosByIdCategoria(int id);

}
