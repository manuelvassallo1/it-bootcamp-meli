package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "empleados")
@TypeAlias("empleado")
@Getter
@Setter
public class Empleado {
    @Id
    private Integer id;
    private String nombre;
    private Integer edad;
    private String ciudad;
}
