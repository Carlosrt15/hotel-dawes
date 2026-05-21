package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.EmpleadoDTO;
import com.example.demo.entity.Empleado;
import com.example.demo.repository.EmpleadoRepository;

@Service
public class EmpleadoService {

	@Autowired
	private EmpleadoRepository repository;

	@Transactional(readOnly = true)
	public List<EmpleadoDTO> obtenerTodos() {
		return repository.findAll().stream().map(this::toDTO).toList();
	}

	@Transactional(readOnly = true)
	public List<EmpleadoDTO> filtrarPorCargo(String cargo) {
		return repository.findByCargo(cargo).stream().map(this::toDTO).toList();
	}

	@Transactional // escritura: commit automático al final
	public void guardar(EmpleadoDTO dto) {
		Empleado e = new Empleado();
		e.setNombre(dto.getNombre());
		e.setApellido(dto.getApellido()); 
		e.setDni(dto.getDni());           
		e.setCargo(dto.getCargo());
		e.setSalario(dto.getSalario());
		repository.save(e);
	}

	private EmpleadoDTO toDTO(Empleado e) {
		// Ajustado para usar el nuevo constructor de EmpleadoDTO
		return new EmpleadoDTO(e.getNombre(), e.getApellido(), e.getDni(), e.getCargo(), e.getSalario());
	}

}
