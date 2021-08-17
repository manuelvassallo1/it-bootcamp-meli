package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class SubjectDTO {
    @NotNull(message = "El campo name es necesario.")
    @NotEmpty(message = "El nombre de la materia no puede estar vacío.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    String name;

    @NotNull(message = "El campo score es necesario.")
    @DecimalMin(value = "0.0", message = "La mínima nota es 0.0.")
    @DecimalMax(value = "10.0", message = "La máxima nota es 10.0.")
    Double score;
}
