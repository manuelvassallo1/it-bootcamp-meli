package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
class TestObtenerDiplomaController {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    IObtenerDiplomaService iObtenerDiplomaService;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void TestGetAnalyzeScore() throws Exception {
        final long id = 1L;
        MvcResult response = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/analyzeScores/{studentId}", id))
                .andReturn();

        verify(iObtenerDiplomaService, atLeastOnce()).analyzeScores(id);
        Assertions.assertEquals(HttpStatus.OK.value(), response.getResponse().getStatus());
    }

    @Test
    void TestGetAnalyzeScoreStudentNotFound() throws Exception {
        final long id = -1L;

        StudentNotFoundException exception = new StudentNotFoundException(id);
        when(iObtenerDiplomaService.analyzeScores(id)).thenThrow(exception);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/analyzeScores/{studentId}", id))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

}