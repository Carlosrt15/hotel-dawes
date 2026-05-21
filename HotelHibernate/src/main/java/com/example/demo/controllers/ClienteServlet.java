package com.example.demo.controllers;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.servicios.IClienteServicio;
import com.example.demo.serviciosImp.ClienteServicioImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/clientes")
public class ClienteServlet extends HttpServlet {

	private final IClienteServicio servicio = new ClienteServicioImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String habitacion = req.getParameter("habitacion");

		List<ClienteDTO> lista = (habitacion != null && !habitacion.isBlank())
				? servicio.filtrarPorHabitacion(habitacion)
				: servicio.obtenerTodos();

		req.setAttribute("clientes", lista);
		req.setAttribute("habitacionFiltro", habitacion);
		req.getRequestDispatcher("/WEB-INF/views/clientes.jsp").forward(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		ClienteDTO dto = new ClienteDTO();
		dto.setNombre(req.getParameter("nombre"));
		dto.setApellido(req.getParameter("apellido"));
		dto.setDni(req.getParameter("dni"));
		dto.setEmail(req.getParameter("email"));
		dto.setHabitacion(req.getParameter("habitacion"));

		servicio.guardar(dto);
		res.sendRedirect(req.getContextPath() + "/clientes");
	}
}