package com.example.demo.repository;

import com.example.demo.domain.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends ElasticsearchRepository<Empleado, Integer> {
    List<Empleado> findAllByEdad(Integer edad);

    List<Empleado> findAllByNombreContainsIgnoreCase(String nombre);

    List<Empleado> findAllByEdadBetween(Integer from, Integer to);
}


