package com.example.demo.repository;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.dto.ClienteDTO;
import com.example.demo.entity.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT new com.example.demo.dto.ClienteDTO(c.id, c.nombre, c.apellido, c.dni, c.email, c.habitacion) FROM Cliente c")
    ArrayList<ClienteDTO> obtenerClientes();

    @Query("SELECT new com.example.demo.dto.ClienteDTO(c.id, c.nombre, c.apellido, c.dni, c.email, c.habitacion) FROM Cliente c WHERE c.habitacion = :habitacion")
    ArrayList<ClienteDTO> filtrarPorHabitacion(@Param("habitacion") String habitacion);
}