package com.tecso.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecso.demo.component.MovimientoConverter;
import com.tecso.demo.entity.Cliente;
import com.tecso.demo.entity.Movimiento;
import com.tecso.demo.entity.Producto;
import com.tecso.demo.model.MovimientoModel;
import com.tecso.demo.repository.ClienteRepository;
import com.tecso.demo.repository.MovimientoRepository;
import com.tecso.demo.repository.ProductoRepository;
import com.tecso.demo.service.MovimientoService;

@Service
public class MovimientoServiceImpl implements MovimientoService{
	
	@Autowired
	private MovimientoRepository movimientoRepository;
	
	@Autowired
	private MovimientoConverter movimientoConverter;
	
	@Autowired 
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	
	
	@Override
	public List<MovimientoModel> listMovimientos(){
		List<Movimiento> listMovimientos = movimientoRepository.findAll();
		return movimientoConverter.convertListMovimientosEntityToListModel(listMovimientos);
		
	}

	@Override
	public boolean add(MovimientoModel movimientoModel) throws Exception {
		movimientoRepository.save(MovimientoConverter.convertMovimientoModelToEntity(movimientoModel));
		Cliente cliente = clienteRepository.findByDocumento(movimientoModel.getDocumento());
		Producto producto = productoRepository.findByIdProducto(movimientoModel.getIdProducto());
		if(cliente.getSaldo() > movimientoModel.getPrecio() && producto.getCantidad() > 0) {
			cliente.setSaldo(cliente.getSaldo() - movimientoModel.getPrecio());
			clienteRepository.save(cliente);			
			producto.setCantidad(producto.getCantidad() - 1);
			productoRepository.save(producto);
			return true;
		}else {
			return false;
		}
		
	}

}
