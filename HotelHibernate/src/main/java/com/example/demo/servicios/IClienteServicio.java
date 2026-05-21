package com.example.demo.servicios;

import com.example.demo.dto.ClienteDTO;
import java.util.List;

public interface IClienteServicio {
	List<ClienteDTO> obtenerTodos();

	List<ClienteDTO> filtrarPorHabitacion(String habitacion);

	void guardar(ClienteDTO dto);

	void eliminar(Long id);
}