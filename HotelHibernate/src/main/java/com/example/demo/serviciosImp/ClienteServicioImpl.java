package com.example.demo.serviciosImp;

import com.example.demo.dao.IClienteDAO;
import com.example.demo.daoImp.ClienteDAOImpl;
import com.example.demo.dto.ClienteDTO;
import com.example.demo.entities.Cliente;
import com.example.demo.servicios.IClienteServicio;
import java.util.List;

public class ClienteServicioImpl implements IClienteServicio {

	private final IClienteDAO dao = new ClienteDAOImpl();

	@Override
	public List<ClienteDTO> obtenerTodos() {
		return dao.findAll().stream().map(this::toDTO).toList();
	}

	@Override
	public List<ClienteDTO> filtrarPorHabitacion(String habitacion) {
		return dao.findByHabitacion(habitacion).stream().map(this::toDTO).toList();
	}

	@Override
	public void guardar(ClienteDTO dto) {
		Cliente c = new Cliente();
		c.setNombre(dto.getNombre());
		c.setApellido(dto.getApellido());
		c.setDni(dto.getDni());
		c.setEmail(dto.getEmail());
		c.setHabitacion(dto.getHabitacion());
		dao.save(c);
	}

	@Override
	public void eliminar(Long id) {
		dao.delete(id);
	}

	private ClienteDTO toDTO(Cliente c) {
		return new ClienteDTO(c.getId(), c.getNombre(), c.getApellido(), c.getDni(), c.getEmail(), c.getHabitacion());
	}
}