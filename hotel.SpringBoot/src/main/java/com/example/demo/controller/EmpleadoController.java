package com.example.demo.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.dto.EmpleadoDTO;
import com.example.demo.service.EmpleadoService;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

	@Autowired
	EmpleadoService empleadoService;

	@GetMapping
	public String listar(@RequestParam(required = false) String cargo, Model model) {

		ArrayList<EmpleadoDTO> lista = (cargo != null && !cargo.isBlank()) ? empleadoService.filtrarPorCargo(cargo)
				: empleadoService.obtenerEmpleados();

		model.addAttribute("empleados", lista);
		model.addAttribute("cargoFiltro", cargo);
		return "empleados/lista";
	}

	@PostMapping("/insertar")
	public String insertar(@RequestParam String nombre, @RequestParam String apellido, @RequestParam String dni,
			@RequestParam String cargo, @RequestParam Double salario) {

		empleadoService.insertarEmpleado(nombre, apellido, dni, cargo, salario);
		return "redirect:/empleados";
	}
}