package com.meli.tucasita.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class ResponseDTO {
    private String msg;
    private Double value;
}
