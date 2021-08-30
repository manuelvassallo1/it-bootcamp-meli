package com.example.demo.services;

import com.example.demo.domain.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {

    Empleado createEmployee(Empleado empleado);

    String updateEmployee(Empleado empleado);

    Optional<Empleado> findById(Integer id);

    String deleteById(Integer id);

    List<Empleado> findAllByAge(Integer age);

    List<Empleado> findAllByName(String name);

    List<Empleado> findAllByAgeRange(Integer from, Integer to);
}
