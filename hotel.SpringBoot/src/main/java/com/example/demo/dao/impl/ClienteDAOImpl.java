package com.example.demo.dao.impl;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.dao.interfaces.IClienteDAO;
import com.example.demo.dto.ClienteDTO;
import com.example.demo.entity.Cliente;
import com.example.demo.repository.IClienteRepository;

@Repository
public class ClienteDAOImpl implements IClienteDAO {

	@Autowired
	IClienteRepository clienteRepository;

	@Override
	public int insertarCliente(String nombre, String apellido, String dni, String email, String habitacion) {
		Cliente c = new Cliente();
		c.setNombre(nombre);
		c.setApellido(apellido);
		c.setDni(dni);
		c.setEmail(email);
		c.setHabitacion(habitacion);
		clienteRepository.save(c);
		return c.getId().intValue();
	}

	@Override
	public ArrayList<ClienteDTO> obtenerClientes() {
		return clienteRepository.obtenerClientes();
	}

	@Override
	public ArrayList<ClienteDTO> filtrarPorHabitacion(String habitacion) {
		return clienteRepository.filtrarPorHabitacion(habitacion);
	}

	@Override
	public int actualizarCliente(Long id, String nombre, String apellido, String dni, String email, String habitacion) {
		Cliente c = clienteRepository.findById(id).get();
		c.setNombre(nombre);
		c.setApellido(apellido);
		c.setDni(dni);
		c.setEmail(email);
		c.setHabitacion(habitacion);
		clienteRepository.save(c);
		return c.getId().intValue();
	}

	@Override
	public int borrarCliente(Long id) {
		clienteRepository.deleteById(id);
		return id.intValue();
	}
}