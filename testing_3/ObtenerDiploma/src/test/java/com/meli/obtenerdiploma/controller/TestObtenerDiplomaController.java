package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TestObtenerDiplomaController {

    @Mock
    IObtenerDiplomaService iObtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    void TestGetAnalyzeScores() {
        final long id = 1L;
        obtenerDiplomaController.analyzeScores(id);
        Mockito.verify(iObtenerDiplomaService, Mockito.atLeastOnce()).analyzeScores(id);
    }

    @Test
    void TestGetAnalyzeScoresInvalidId() {
        final long id = -1L;
        Mockito.when(iObtenerDiplomaService.analyzeScores(id)).thenThrow(StudentNotFoundException.class);
        Assertions.assertThrows(StudentNotFoundException.class, () -> iObtenerDiplomaService.analyzeScores(id));
    }

    @Test
    void TestGetAnalyzeScoresNullId() {
        Mockito.when(iObtenerDiplomaService.analyzeScores(null)).thenThrow(StudentNotFoundException.class);
        Assertions.assertThrows(StudentNotFoundException.class, () -> iObtenerDiplomaService.analyzeScores(null));
    }
}
