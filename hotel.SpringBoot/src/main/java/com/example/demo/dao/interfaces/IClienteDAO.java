package com.example.demo.dao.interfaces;

import java.util.ArrayList;
import com.example.demo.dto.ClienteDTO;

public interface IClienteDAO {
	int insertarCliente(String nombre, String apellido, String dni, String email, String habitacion);

	ArrayList<ClienteDTO> obtenerClientes();

	ArrayList<ClienteDTO> filtrarPorHabitacion(String habitacion);

	int actualizarCliente(Long id, String nombre, String apellido, String dni, String email, String habitacion);

	int borrarCliente(Long id);
}