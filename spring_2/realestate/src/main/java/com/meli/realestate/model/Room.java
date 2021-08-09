package com.meli.realestate.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Room {
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private double width;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private double lenght;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private double area;
}
