package com.meli.tucasita.model;

import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDTO {
    @NotBlank(message = "El campo barrio no puede estar vacio.")
    @Size(max = 45, message = "La longitud del nombre del barrio no puede superar los 45 caracteres.")
    @Pattern(regexp = "(?=^[A-Z]).*", message = "El nombre del barrio debe comenzar con mayuscula.")
    private String districtName;

    @NotNull(message = "El precio del metro cuadrado construido de un barrio no puede estar vacío.")
    @DecimalMax(value = "4000.0", message = "El precio maximo permitido por metro cuadrado construido es de 4000 U$S.")
    @Positive(message = "El precio por metro cuadrado construido debe ser positivo.")
    private Double districtBuiltPrice;

    @NotNull(message = "El precio del metro cuadrado NO construido de un barrio no puede estar vacío.")
    @DecimalMax(value = "1000.0", message = "El precio maximo permitido por metro cuadrado NO construido es de 1000 U$S.")
    @Positive(message = "El precio por metro cuadrado NO construido debe ser positivo.")
    private Double districtUnbuiltPrice;
}
