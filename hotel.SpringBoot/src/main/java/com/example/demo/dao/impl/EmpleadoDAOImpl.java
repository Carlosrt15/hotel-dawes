package com.example.demo.dao.impl;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.dao.interfaces.IEmpleadoDAO;
import com.example.demo.dto.EmpleadoDTO;
import com.example.demo.entity.Empleado;
import com.example.demo.repository.EmpleadoRepository;

@Repository
public class EmpleadoDAOImpl implements IEmpleadoDAO {

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Override
    public ArrayList<EmpleadoDTO> obtenerEmpleados() {
        return empleadoRepository.obtenerEmpleados();
    }

    @Override
    public ArrayList<EmpleadoDTO> filtrarPorCargo(String cargo) {
        return empleadoRepository.filtrarPorCargo(cargo);
    }

    @Override
    public void insertarEmpleado(String nombre, String apellido, String dni,
                                  String cargo, Double salario) {
        Empleado e = new Empleado();
        e.setNombre(nombre);
        e.setApellido(apellido);
        e.setDni(dni);
        e.setCargo(cargo);
        e.setSalario(salario);
        empleadoRepository.save(e);
    }
}