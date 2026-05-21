package com.example.demo.dto;

public class EmpleadoDTO {

	private Long id; // ← añadir
	private String nombre;
	private String apellido;
	private String dni;
	private String cargo;
	private Double salario;

	public EmpleadoDTO() {
	}

	// ← añadir id como primer parámetro
	public EmpleadoDTO(Long id, String nombre, String apellido, String dni, String cargo, Double salario) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.cargo = cargo;
		this.salario = salario;
	}

	// ← añadir getter y setter del id
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String c) {
		this.cargo = c;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double s) {
		this.salario = s;
	}
}