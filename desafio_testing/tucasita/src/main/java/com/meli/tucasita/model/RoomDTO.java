package com.meli.tucasita.model;

import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class RoomDTO {
    @NotBlank(message = "El nombre del ambiente no puede estar vacio.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    @Pattern(regexp = "(?=^[A-Z]).*", message = "El nombre del ambiente debe comenzar con mayuscula.")
    private String roomName;

    @NotNull(message = "El ancho del ambiente no puede estar vacio.")
    @DecimalMax(value = "25.0", message = "El maximo ancho permitido por propiedad es de 25 mts.")
    @Positive(message = "El ancho debe ser positivo.")
    private Double roomWidth;

    @NotNull(message = "El largo del ambiente no puede estar vacio.")
    @DecimalMax(value = "33.0", message = "El maximo largo permitido por propiedad es de 33 mts.")
    @Positive(message = "El largo debe ser positivo.")
    private Double roomLength;
}
