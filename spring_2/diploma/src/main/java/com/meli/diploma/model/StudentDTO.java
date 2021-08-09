package com.meli.diploma.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDTO {
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<SubjectDTO> subjects;
}
