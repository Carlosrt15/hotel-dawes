package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

	// Spring genera el SQL solo a partir del nombre del método
    List<Empleado> findByCargo(String cargo);
}
