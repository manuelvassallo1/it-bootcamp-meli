package com.example.demo.controllers;

import com.example.demo.domain.Empleado;
import com.example.demo.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public Empleado createEmployee(@RequestBody Empleado empleado) {
        return empleadoService.createEmployee(empleado);
    }

    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Empleado> findById(@PathVariable Integer id) {
        return empleadoService.findById(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public String updateEmployee(@RequestBody Empleado empleado) {
        return empleadoService.updateEmployee(empleado);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteById(@PathVariable Integer id) {
        return empleadoService.deleteById(id);
    }

    @GetMapping("/age/{age}")
    @ResponseStatus(HttpStatus.OK)
    public List<Empleado> findAllByAge(@PathVariable Integer age) {
        return empleadoService.findAllByAge(age);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Empleado> findAllByName(@PathVariable String name) {
        return empleadoService.findAllByName(name);
    }

    @GetMapping("/ageRange/{from}/{to}")
    @ResponseStatus(HttpStatus.OK)
    public List<Empleado> findAllByAgeRange(@PathVariable Integer from, @PathVariable Integer to) {
        return empleadoService.findAllByAgeRange(from, to);
    }
}
