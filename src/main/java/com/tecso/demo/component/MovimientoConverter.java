package com.tecso.demo.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tecso.demo.entity.Movimiento;
import com.tecso.demo.model.MovimientoModel;

@Component
public class MovimientoConverter {

	public static MovimientoModel convertMovimientoEntityToModel(Movimiento movimiento) {

		MovimientoModel movimientoModel = new MovimientoModel(movimiento.getId(), movimiento.getDocumento(),
				movimiento.getCategoria(), movimiento.getIdProducto(), movimiento.getProducto(), movimiento.getPrecio(), movimiento.getDireccion());

		return movimientoModel;

	}

	public static Movimiento convertMovimientoModelToEntity(MovimientoModel movimientoModel) {

		Movimiento movimiento = new Movimiento(movimientoModel.getId(), movimientoModel.getDocumento(),
				movimientoModel.getCategoria(), movimientoModel.getIdProducto(), movimientoModel.getProducto(), movimientoModel.getPrecio(),
				movimientoModel.getDireccion());

		return movimiento;

	}

	public List<MovimientoModel> convertListMovimientosEntityToListModel(List<Movimiento> movimientos) {

		List<MovimientoModel> listMovimientos = new ArrayList<MovimientoModel>();;

		if (movimientos.size() > 0) {			

			for (int i = 0; i < movimientos.size(); i++) {
				MovimientoModel movimiento = new MovimientoModel(movimientos.get(i).getId(),
						movimientos.get(i).getDocumento(), movimientos.get(i).getCategoria(),
						movimientos.get(i).getIdProducto(), movimientos.get(i).getProducto(), movimientos.get(i).getPrecio(),
						movimientos.get(i).getDireccion());
				listMovimientos.add(movimiento);
			}

		}

		return listMovimientos;

	}

}
