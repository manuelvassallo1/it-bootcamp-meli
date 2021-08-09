package com.meli.socialmeli.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class DetailDTO {
    @NotNull(message = "El campo 'product_id' es obligatorio")
    private Integer product_id;

    @NotNull(message = "El campo 'productName' es obligatorio")
    private String productName;

    @NotNull(message = "El campo 'type' es obligatorio")
    private String type;

    @NotNull(message = "El campo 'brand' es obligatorio")
    private String brand;

    @NotNull(message = "El campo 'color' es obligatorio")
    private String color;

    @NotNull(message = "El campo 'notes' es obligatorio")
    private String notes;
}
