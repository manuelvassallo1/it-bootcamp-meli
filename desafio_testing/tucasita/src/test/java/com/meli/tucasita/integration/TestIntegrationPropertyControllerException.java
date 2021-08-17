package com.meli.tucasita.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.tucasita.exceptions.NoSuchDistrictException;
import com.meli.tucasita.exceptions.WrongRoomsSizeException;
import com.meli.tucasita.exceptions.model.ErrorDTO;
import com.meli.tucasita.exceptions.model.FieldErrorResponseDTO;
import com.meli.tucasita.model.PropertyDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.nio.charset.StandardCharsets;

import static com.meli.tucasita.util.TestUtilGenerator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
class TestIntegrationPropertyControllerException {

    @Autowired
    MockMvc mockMvc;

    PropertyDTO testProperty;
    ObjectMapper mapper = new ObjectMapper();

    @Test
    void TestNoSuchDistrictException() throws Exception {
        //Arrange
        testProperty = getPropertyWithWrongDistrict();
        String payload = mapper.writeValueAsString(testProperty);
        ErrorDTO expected = new ErrorDTO("NoSuchDistrictException", "El barrio La Ferrere no existe.");
        //Act
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post("/property/area")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andReturn();
        ErrorDTO received = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
        });
        //Assert
        Assertions.assertEquals(expected, received);
        assertEquals(HttpStatus.BAD_REQUEST.value(), result.getResponse().getStatus());
        assertTrue(result.getResolvedException() instanceof NoSuchDistrictException);
    }

    @Test
    void TestWrongRoomsSizeException() throws Exception {
        //Arrange
        testProperty = getPropertyWithWrongRoomSize();
        String payload = mapper.writeValueAsString(testProperty);
        ErrorDTO expected = new ErrorDTO("WrongRoomsSizeException", "El area de los dormitorios no puede superar el area total de la propiedad.");
        //Act
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post("/property/area")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andReturn();
        ErrorDTO received = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
        });
        //Assert
        Assertions.assertEquals(expected, received);
        assertEquals(HttpStatus.BAD_REQUEST.value(), result.getResponse().getStatus());
        assertTrue(result.getResolvedException() instanceof WrongRoomsSizeException);
    }

    @Test
    void TestHttpMessageNotReadableException() throws Exception {
        //Act
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post("/property/area")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andReturn();
        //Assert
        assertEquals(HttpStatus.BAD_REQUEST.value(), result.getResponse().getStatus());
        assertTrue(result.getResolvedException() instanceof HttpMessageNotReadableException);
    }

    @Test
    void TestFieldValidations() throws Exception {
        //Arrange
        testProperty = getPropertyWithWrongFields();
        String payload = mapper.writeValueAsString(testProperty);
        //Act
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post("/property/area")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andReturn();
        FieldErrorResponseDTO received = mapper.readValue(result.getResponse().getContentAsString(StandardCharsets.UTF_8), new TypeReference<>() {
        });
        //Assert
        Assertions.assertEquals(11, received.getFieldErrors().size());
        assertEquals(HttpStatus.BAD_REQUEST.value(), result.getResponse().getStatus());
        assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException);
    }
}
