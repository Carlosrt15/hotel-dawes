package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.dto.ClienteDTO;
import com.example.demo.entity.Cliente;
import com.example.demo.repository.IClienteRepository;
// ← eliminado EmpleadoRepository, no se usa

@Service
public class ClienteService {

    @Autowired
    private IClienteRepository repository;

    @Transactional(readOnly = true)
    public List<ClienteDTO> obtenerTodos() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    @Transactional(readOnly = true)
    public List<ClienteDTO> filtrarPorHabitacion(String habitacion) {
        return repository.findByHabitacion(habitacion).stream().map(this::toDTO).toList();
    }

    @Transactional
    public void guardar(ClienteDTO dto) {
        Cliente c = new Cliente();
        // ← NO asignar id: la BD lo genera sola con @GeneratedValue
        c.setNombre(dto.getNombre());
        c.setApellido(dto.getApellido());
        c.setDni(dto.getDni());
        c.setEmail(dto.getEmail());
        c.setHabitacion(dto.getHabitacion());
        repository.save(c);
    }

    private ClienteDTO toDTO(Cliente c) {
        return new ClienteDTO(
            c.getId(),        // ← añadido, primer parámetro del constructor
            c.getNombre(),
            c.getApellido(),
            c.getDni(),
            c.getEmail(),
            c.getHabitacion()
        );
    }
}