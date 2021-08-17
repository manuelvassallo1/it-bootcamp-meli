package com.meli.tucasita.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTO {
    @NotBlank(message = "El nombre de la propiedad no puede estar vacio.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    @Pattern(regexp = "(?=^[A-Z]).*", message = "El nombre de la propiedad debe comenzar con mayuscula.")
    private String propName;

    @NotNull(message = "El ancho del terreno no puede estar vacio.")
    @Positive(message = "El ancho del terreno debe ser positivo.")
    @DecimalMax(value = "75.0", message = "El maximo ancho permitido por terreno es de 75 mts.")
    private Double propLandWidth;

    @NotNull(message = "El largo del terreno no puede estar vacio.")
    @Positive(message = "El largo del terreno debe ser positivo.")
    @DecimalMax(value = "100.0", message = "El maximo largo permitido por terreno es de 100 mts.")
    private Double propLandLength;

    @Valid
    @NotNull
    private DistrictDTO district;

    @NotNull
    private List<@Valid RoomDTO> rooms;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double propertyArea;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double roomsTotalArea;
}
