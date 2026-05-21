package com.example.demo.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.dto.ClienteDTO;
import com.example.demo.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public String listar(
            @RequestParam(required = false) String habitacion,
            Model model) {

        ArrayList<ClienteDTO> lista = (habitacion != null && !habitacion.isBlank())
                ? clienteService.filtrarPorHabitacion(habitacion)
                : clienteService.obtenerClientes();

        model.addAttribute("clientes", lista);
        model.addAttribute("habitacionFiltro", habitacion);
        return "clientes/lista";
    }

    @PostMapping("/insertar")
    public String insertar(
            @RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam String dni,
            @RequestParam String email,
            @RequestParam String habitacion) {

        clienteService.insertarCliente(nombre, apellido, dni, email, habitacion);
        return "redirect:/clientes";
    }

    @PostMapping("/borrar")
    public String borrar(@RequestParam Long id) {
        clienteService.borrarCliente(id);
        return "redirect:/clientes";
    }
}