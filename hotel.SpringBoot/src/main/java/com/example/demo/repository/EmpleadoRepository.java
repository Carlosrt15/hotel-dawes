package com.example.demo.repository;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.dto.EmpleadoDTO;
import com.example.demo.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

	@Query("SELECT new com.example.demo.dto.EmpleadoDTO(e.id, e.nombre, e.apellido, e.dni, e.cargo, e.salario) FROM Empleado e")
	ArrayList<EmpleadoDTO> obtenerEmpleados();

	@Query("SELECT new com.example.demo.dto.EmpleadoDTO(e.id, e.nombre, e.apellido, e.dni, e.cargo, e.salario) FROM Empleado e WHERE e.cargo = :cargo")
	ArrayList<EmpleadoDTO> filtrarPorCargo(@Param("cargo") String cargo);
}