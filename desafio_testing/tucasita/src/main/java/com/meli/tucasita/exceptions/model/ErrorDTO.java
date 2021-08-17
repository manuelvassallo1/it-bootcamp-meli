package com.meli.tucasita.exceptions.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ErrorDTO {

    private String errorName;
    private String errorDescription;

}
