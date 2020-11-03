package com.tecso.demo.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tecso.demo.entity.Producto;
import com.tecso.demo.model.ProductoModel;

@Component
public class ProductoConverter {

	public static ProductoModel convertProductoEntityToModel(Producto producto) {

		ProductoModel productoModel = new ProductoModel(producto.getIdProducto(), producto.getNombre(),
				producto.getDescripcion(), producto.getPrecio(), producto.getCantidad(), producto.getCodigoBarra(),
				CategoriaConverter.convertCategoriaEntityToModel(producto.getCategoria()));

		return productoModel;

	}
	
	public static Producto convertProductoModelToEntity(ProductoModel productoModel) {

		Producto producto = new Producto();
		
		producto.setIdProducto(productoModel.getIdProducto());
		producto.setNombre(productoModel.getNombre());
		producto.setDescripcion(productoModel.getDescripcion());
		producto.setPrecio(productoModel.getPrecio());
		producto.setCantidad(productoModel.getCantidad());
		producto.setCodigoBarra(productoModel.getCodigoBarra());
		producto.setCategoria(CategoriaConverter.convertCategoriaModelToEntity(productoModel.getCategoria()));

		return producto;

	}

	public List<ProductoModel> convertListProductoEntityToListModel(List<Producto> productos) {

		List<ProductoModel> listProductoModel = null;

		if (productos.size() > 0) {
			listProductoModel = new ArrayList<ProductoModel>();
			for (int i = 0; i < productos.size(); i++) {
				ProductoModel productoModel = new ProductoModel();
				productoModel.setIdProducto(productos.get(i).getIdProducto());
				productoModel.setNombre(productos.get(i).getNombre());
				productoModel.setDescripcion(productos.get(i).getDescripcion());
				productoModel.setPrecio(productos.get(i).getPrecio());
				productoModel.setCantidad(productos.get(i).getCantidad());
				productoModel.setCodigoBarra(productos.get(i).getCodigoBarra());
				productoModel.setCategoria(CategoriaConverter.convertCategoriaEntityToModel(productos.get(i).getCategoria()));
				listProductoModel.add(productoModel);
			}
		}
		
		return listProductoModel;

	}
	

}
