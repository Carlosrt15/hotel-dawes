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

import com.example.demo.dto.EmpleadoDTO;
import com.example.demo.service.EmpleadoService;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService service;

    // GET /empleados  — lista todos o filtra por cargo
    @GetMapping
    public String listar(
            @RequestParam(required = false) String cargo,
            Model model) {

        List<EmpleadoDTO> lista = (cargo != null && !cargo.isBlank())
                ? service.filtrarPorCargo(cargo)
                : service.obtenerTodos();

        model.addAttribute("empleados", lista);
        model.addAttribute("cargoFiltro", cargo);
        return "empleados/lista";   // → templates/empleados/lista.html
    }

    // GET /empleados/nuevo  — muestra formulario vacío
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("empleado", new EmpleadoDTO());
        return "empleados/formulario";
    }

    // POST /empleados/guardar  — procesa el formulario
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute EmpleadoDTO dto) {
        service.guardar(dto);
        return "redirect:/empleados"; 
    }
}