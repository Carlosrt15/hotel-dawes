package com.example.demo.dto;

public class ClienteDTO {

	private Long id;
	private String nombre, apellido, dni, email, habitacion;

	public ClienteDTO() {
	}

	public ClienteDTO(Long id, String nombre, String apellido, String dni, String email, String habitacion) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
		this.habitacion = habitacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String n) {
		this.nombre = n;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String a) {
		this.apellido = a;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String d) {
		this.dni = d;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String e) {
		this.email = e;
	}

	public String getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(String h) {
		this.habitacion = h;
	}
}