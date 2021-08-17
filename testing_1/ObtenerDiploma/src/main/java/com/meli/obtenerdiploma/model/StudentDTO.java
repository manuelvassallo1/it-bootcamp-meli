package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Getter
@Setter
public class StudentDTO {

    @NotNull(message = "El campo studentName es necesario.")
    @NotEmpty(message = "El nombre del alumno no puede estar vacío.")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    String studentName;

    String message;
    Double averageScore;

    @NotNull(message = "El campo subjects es necesario.")
    @NotEmpty(message = "La lista no puede ser vacía.")
    List<@Valid SubjectDTO> subjects;
}
