package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.dto.ClienteDTO;
import com.example.demo.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    // GET /clientes — lista todos o filtra por habitacion
    @GetMapping
    public String listar(
            @RequestParam(required = false) String habitacion,
            Model model) {

        List<ClienteDTO> lista = (habitacion != null && !habitacion.isBlank())
                ? service.filtrarPorHabitacion(habitacion)
                : service.obtenerTodos();

        model.addAttribute("clientes", lista);
        model.addAttribute("habitacionFiltro", habitacion);
        return "clientes/lista";  // → templates/clientes/lista.html
    }

    // GET /clientes/nuevo — muestra formulario vacío
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("cliente", new ClienteDTO());
        return "clientes/formulario";  // → templates/clientes/formulario.html
    }

    // POST /clientes/guardar — procesa el formulario
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute ClienteDTO dto) {
        service.guardar(dto);
        return "redirect:/clientes";  // PRG: evita doble envío al refrescar
    }
}