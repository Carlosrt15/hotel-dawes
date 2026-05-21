package com.example.demo.dao.interfaces;

import java.util.ArrayList;
import com.example.demo.dto.EmpleadoDTO;

public interface IEmpleadoDAO {
	ArrayList<EmpleadoDTO> obtenerEmpleados();

	ArrayList<EmpleadoDTO> filtrarPorCargo(String cargo);

	void insertarEmpleado(String nombre, String apellido, String dni, String cargo, Double salario);
}