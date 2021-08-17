package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.util.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TestObtenerDiplomaService {
    @Mock
    IStudentDAO iStudentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void TestAnalyzeScoreCorrectId() {
        StudentDTO expected = TestUtilGenerator.getStudents().get(0);
        Mockito.when(iStudentDAO.findById(1L)).thenReturn(expected);

        expected.setAverageScore(7.33);
        expected.setMessage("El alumno Juan ha obtenido un promedio de 7.33. Felicitaciones!");

        StudentDTO received = obtenerDiplomaService.analyzeScores(1L);

        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).findById(1L);
        Assertions.assertEquals(expected.getAverageScore(), received.getAverageScore());
        Assertions.assertEquals(expected.getMessage(), received.getMessage());

    }

    @Test
    void TestAnalyzeScoreInvalidId() {
        Mockito.when(iStudentDAO.findById(-1L)).thenThrow(StudentNotFoundException.class);

        Assertions.assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(-1L));
    }

    @Test
    void TestAnalyzeScoreNullId() {
        Mockito.when(iStudentDAO.findById(null)).thenThrow(StudentNotFoundException.class);

        Assertions.assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(null));
    }


}
