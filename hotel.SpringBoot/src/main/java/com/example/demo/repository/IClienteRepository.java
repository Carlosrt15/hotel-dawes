package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {
	
	List<Cliente> findByHabitacion(String habitacion);

}
