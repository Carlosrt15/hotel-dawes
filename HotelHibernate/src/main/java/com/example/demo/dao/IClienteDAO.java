package com.example.demo.dao;

import com.example.demo.entities.Cliente;
import java.util.List;

public interface IClienteDAO {
	List<Cliente> findAll();

	List<Cliente> findByHabitacion(String habitacion);

	Cliente findById(Long id);

	void save(Cliente c);

	void delete(Long id);
}