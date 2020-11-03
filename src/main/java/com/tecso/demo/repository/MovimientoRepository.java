package com.tecso.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tecso.demo.entity.Movimiento;

@Repository("movimientoRepository")
public interface MovimientoRepository extends JpaRepository<Movimiento, Serializable>{
	
}
