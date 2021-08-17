package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exceptions.student.InvalidStudentNameException;
import com.meli.obtenerdiploma.exceptions.student.InvalidSubjectNameException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class ObtenerDiplomaService implements IObtenerDiplomaService {

    @Override
    public StudentDTO analyzeScores(StudentDTO rq) {
        isValid(rq);
        rq.setAverageScore(calculateAverage(rq.getSubjects()));
        rq.setMessage(getGreetingMessage(rq.getStudentName(), rq.getAverageScore()));

        return rq;
    }

    private String getGreetingMessage(String studentName, Double average) {
        return "El alumno " + studentName + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(average)
                + ((average > 9) ? ". Felicitaciones!" : ". Puedes mejorar.");
    }

    private Double calculateAverage(List<SubjectDTO> scores) {
        return scores.stream()
                .reduce(0D, (partialSum, score) -> partialSum + score.getScore(), Double::sum)
                / scores.size();
    }

    private void isValid(StudentDTO rq) {
        if (!isUpperCase(rq.getStudentName())) {
            throw new InvalidStudentNameException("El nombre del alumno comenzar con mayúscula.");
        }
        if (!rq.getSubjects().stream().allMatch(s -> isUpperCase(s.getName()))) {
            throw new InvalidSubjectNameException("El nombre de la materia debe comenzar con mayúscula");
        }
    }

    private boolean isUpperCase(String s) {
        return Character.isUpperCase(s.codePointAt(0));
    }
}
