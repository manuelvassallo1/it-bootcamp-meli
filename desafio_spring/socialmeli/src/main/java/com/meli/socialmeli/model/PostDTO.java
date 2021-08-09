package com.meli.socialmeli.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class PostDTO {
    @NotNull(message = "El campo 'userId' es obligatorio")
    private Integer userId;

    @NotNull(message = "El campo 'id_post' es obligatorio")
    private Integer id_post;

    @NotNull(message = "El campo 'date' es obligatorio")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    @Valid
    private DetailDTO detail;

    @NotNull(message = "El campo 'category' es obligatorio")
    private Integer category;

    @NotNull(message = "El campo 'price' es obligatorio")
    private Double price;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean hasPromo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double discount;
}
