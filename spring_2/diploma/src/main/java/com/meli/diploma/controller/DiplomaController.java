package com.meli.diploma.controller;

import com.meli.diploma.model.DiplomaDTO;
import com.meli.diploma.model.StudentDTO;
import com.meli.diploma.model.SubjectDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DiplomaController {

    @PostMapping("/diploma")
    public DiplomaDTO getDiploma(@RequestBody StudentDTO studentDTO) {
        Double avgScore = getAvgScore(studentDTO.getSubjects());
        String msg = getMsg(avgScore);
        return new DiplomaDTO(msg, avgScore, studentDTO);
    }

    private Double getAvgScore(List<SubjectDTO> subjects) {
        return subjects
                .stream()
                .map(SubjectDTO::getScore)
                .collect(Collectors.summarizingDouble(Double::doubleValue))
                .getAverage();
    }

    private String getMsg(Double avgScore) {
        String msg = "";
        if (avgScore > 9) {
            msg += "Felicitaciones por obtener tu diploma de honor!";
        } else {
            msg += "Has obtenido tu diploma.";
        }
        return msg;
    }
}
