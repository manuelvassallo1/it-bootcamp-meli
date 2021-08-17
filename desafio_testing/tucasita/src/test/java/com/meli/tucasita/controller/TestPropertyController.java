package com.meli.tucasita.controller;

import com.meli.tucasita.model.PropertyDTO;
import com.meli.tucasita.model.ResponseDTO;
import com.meli.tucasita.model.RoomDTO;
import com.meli.tucasita.service.IPropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

import static com.meli.tucasita.util.TestUtilGenerator.getAllDistricts;
import static com.meli.tucasita.util.TestUtilGenerator.getPropertyOk;

@ExtendWith(MockitoExtension.class)
class TestPropertyController {

    @Mock
    IPropertyService service;

    @InjectMocks
    PropertyController propertyController;

    @Test
    void TestCalculatePropertyArea() {
        PropertyDTO propertyDTO = getPropertyOk();

        ResponseDTO expected = new ResponseDTO("Area total de la propiedad.", 25.0);
        Mockito.when(service.getPropertyArea(propertyDTO)).thenReturn(expected);

        ResponseEntity<ResponseDTO> received = propertyController.calculatePropertyArea(propertyDTO);

        Mockito.verify(service, Mockito.atLeastOnce()).getPropertyArea(propertyDTO);
        Assertions.assertEquals(expected, received.getBody());
    }

    @Test
    void TestCalculatePropertyValue() {
        PropertyDTO propertyDTO = getPropertyOk();

        ResponseDTO expected = new ResponseDTO("Valor total de la propiedad.", 705.0);
        Mockito.when(service.getPropertyValue(propertyDTO)).thenReturn(expected);

        ResponseEntity<ResponseDTO> received = propertyController.calculatePropertyValue(propertyDTO);

        Mockito.verify(service, Mockito.atLeastOnce()).getPropertyValue(propertyDTO);
        Assertions.assertEquals(expected, received.getBody());
    }

    @Test
    void TestCalculateBiggestRoom() {
        PropertyDTO propertyDTO = getPropertyOk();

        RoomDTO expected = new RoomDTO("Habitacion 1", 5.0, 5.0);
        Mockito.when(service.getBiggestRoom(propertyDTO)).thenReturn(expected);

        ResponseEntity<RoomDTO> received = propertyController.calculateBiggestRoom(propertyDTO);

        Mockito.verify(service, Mockito.atLeastOnce()).getBiggestRoom(propertyDTO);
        Assertions.assertEquals(expected, received.getBody());
    }

    @Test
    void TestCalculateRoomsArea() {
        PropertyDTO propertyDTO = getPropertyOk();

        ResponseDTO r1 = new ResponseDTO("Habitacion 1", 25.0);
        ResponseDTO r2 = new ResponseDTO("Habitacion 2", 16.0);

        List<ResponseDTO> expected = List.of(r1, r2);

        Mockito.when(service.getRoomsArea(propertyDTO)).thenReturn(expected);

        ResponseEntity<List<ResponseDTO>> received = propertyController.calculateRoomsArea(propertyDTO);

        Mockito.verify(service, Mockito.atLeastOnce()).getRoomsArea(propertyDTO);
        Assertions.assertEquals(expected, received.getBody());
    }

    @Test
    void TestGetAllDistricts() {
        Set<String> expected = getAllDistricts();

        Mockito.when(service.getAllDistricts()).thenReturn(expected);

        ResponseEntity<Set<String>> received = propertyController.getAllDistricts();

        Mockito.verify(service, Mockito.atLeastOnce()).getAllDistricts();
        Assertions.assertEquals(expected, received.getBody());
    }

}
