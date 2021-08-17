package com.meli.tucasita.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.tucasita.model.PropertyDTO;
import com.meli.tucasita.model.ResponseDTO;
import com.meli.tucasita.model.RoomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;

import static com.meli.tucasita.util.TestUtilGenerator.getAllDistricts;
import static com.meli.tucasita.util.TestUtilGenerator.getPropertyOk;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class TestIntegrationPropertyController {
    @Autowired
    MockMvc mockMvc;

    PropertyDTO testProperty;
    ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        testProperty = getPropertyOk();
    }

    @Test
    void TestCalculatePropertyAreaOk() throws Exception {
        //Arrange
        String payload = mapper.writeValueAsString(testProperty);
        ResponseDTO expected = new ResponseDTO("Area total de la propiedad.", 1200.0);
        //Act
        MvcResult response = mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/property/area")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andReturn();

        ResponseDTO received = mapper.readValue(response.getResponse().getContentAsString(), new TypeReference<>() {
        });
        //Assert
        assertEquals(HttpStatus.OK.value(), response.getResponse().getStatus());
        assertEquals(expected, received);
    }

    @Test
    void TestCalculatePropertyValueOk() throws Exception {
        //Arrange
        String payload = mapper.writeValueAsString(testProperty);
        ResponseDTO expected = new ResponseDTO("Valor total de la propiedad.", 62050.0);
        //Act
        MvcResult response = mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/property/value")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andReturn();

        ResponseDTO received = mapper.readValue(response.getResponse().getContentAsString(), new TypeReference<>() {
        });
        //Assert
        assertEquals(HttpStatus.OK.value(), response.getResponse().getStatus());
        assertEquals(expected, received);
    }

    @Test
    void TestCalculateBiggestRoomOk() throws Exception {
        //Arrange
        String payload = mapper.writeValueAsString(testProperty);
        RoomDTO expected = new RoomDTO("Habitacion 1", 5.0, 5.0);
        //Act
        MvcResult response = mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/rooms/biggest")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andReturn();

        RoomDTO received = mapper.readValue(response.getResponse().getContentAsString(), new TypeReference<>() {
        });
        //Assert
        assertEquals(HttpStatus.OK.value(), response.getResponse().getStatus());
        assertEquals(expected, received);
    }

    @Test
    void TestCalculateRoomsAreaOk() throws Exception {
        //Arrange
        String payload = mapper.writeValueAsString(testProperty);
        ResponseDTO r1 = new ResponseDTO("Habitacion 1", 25.0);
        ResponseDTO r2 = new ResponseDTO("Habitacion 2", 16.0);

        List<ResponseDTO> expected = List.of(r1, r2);
        //Act
        MvcResult response = mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/rooms/area")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andReturn();

        List<ResponseDTO> received = mapper.readValue(response.getResponse().getContentAsString(), new TypeReference<>() {
        });
        //Assert
        assertEquals(HttpStatus.OK.value(), response.getResponse().getStatus());
        assertEquals(expected, received);
    }

    @Test
    void TestGetAllDistricts() throws Exception {
        //Arrange
        Set<String> expected = getAllDistricts();
        //Act
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/districts"))
                .andReturn();
        Set<String> received = mapper.readValue(result.getResponse().getContentAsString(StandardCharsets.UTF_8), new TypeReference<>() {
        });

        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        assertEquals(expected, received);
    }
}
