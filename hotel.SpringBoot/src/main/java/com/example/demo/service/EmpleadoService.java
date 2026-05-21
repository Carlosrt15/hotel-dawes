package com.example.demo.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.interfaces.IEmpleadoDAO;
import com.example.demo.dto.EmpleadoDTO;

@Service
public class EmpleadoService {

	@Autowired
	IEmpleadoDAO empleadoDAO;

	public ArrayList<EmpleadoDTO> obtenerEmpleados() {
		return empleadoDAO.obtenerEmpleados();
	}

	public ArrayList<EmpleadoDTO> filtrarPorCargo(String cargo) {
		return empleadoDAO.filtrarPorCargo(cargo);
	}

	public void insertarEmpleado(String nombre, String apellido, String dni, String cargo, Double salario) {
		empleadoDAO.insertarEmpleado(nombre, apellido, dni, cargo, salario);
	}
}