package com.meli.linktracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties({"password", "metricsDTO"})
public class ResponseDTO {
    private String url;
    private MetricsDTO metricsDTO;
    private boolean active;
    private String password;
    private Integer id;

    public ResponseDTO(String url, String password) {
        this.url = url;
        metricsDTO = new MetricsDTO();
        active = true;
        this.password = password;
        id = 0;
    }
}
