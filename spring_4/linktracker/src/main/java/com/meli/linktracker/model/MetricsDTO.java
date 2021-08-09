package com.meli.linktracker.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetricsDTO {
    private Integer redirections;

    public MetricsDTO() {
        redirections = 0;
    }
}
