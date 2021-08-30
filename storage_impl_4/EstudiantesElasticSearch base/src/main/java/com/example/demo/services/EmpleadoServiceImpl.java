package com.example.demo.services;

import com.example.demo.domain.Empleado;
import com.example.demo.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository repository;

    @Override
    public Empleado createEmployee(Empleado empleado) {
        return repository.save(empleado);
    }

    @Override
    public String updateEmployee(Empleado empleado) {
        if (!repository.existsById(empleado.getId())) {
            return "No se encontro el empleado.";
        }
        repository.save(empleado);
        return "Empleado actualizado correctamente.";
    }

    @Override
    public Optional<Empleado> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public String deleteById(Integer id) {
        if (!repository.existsById(id)) {
            return "No se encontro el empleado.";
        }

        repository.deleteById(id);
        return "Eliminado correctamente.";
    }

    @Override
    public List<Empleado> findAllByAge(Integer age) {
        return repository.findAllByEdad(age);
    }

    @Override
    public List<Empleado> findAllByName(String name) {
        return repository.findAllByNombreContainsIgnoreCase(name);
    }

    @Override
    public List<Empleado> findAllByAgeRange(Integer from, Integer to) {
        return repository.findAllByEdadBetween(from, to);
    }
}
