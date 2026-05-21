package com.example.demo.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.interfaces.IClienteDAO;
import com.example.demo.dto.ClienteDTO;

@Service
public class ClienteService {

    @Autowired
    IClienteDAO clienteDAO;

    public int insertarCliente(String nombre, String apellido, String dni,
                                String email, String habitacion) {
        return clienteDAO.insertarCliente(nombre, apellido, dni, email, habitacion);
    }

    public ArrayList<ClienteDTO> obtenerClientes() {
        return clienteDAO.obtenerClientes();
    }

    public ArrayList<ClienteDTO> filtrarPorHabitacion(String habitacion) {
        return clienteDAO.filtrarPorHabitacion(habitacion);
    }

    public int actualizarCliente(Long id, String nombre, String apellido,
                                  String dni, String email, String habitacion) {
        return clienteDAO.actualizarCliente(id, nombre, apellido, dni, email, habitacion);
    }

    public int borrarCliente(Long id) {
        return clienteDAO.borrarCliente(id);
    }
}