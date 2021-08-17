package com.meli.tucasita.service;

import com.meli.tucasita.model.PropertyDTO;
import com.meli.tucasita.model.ResponseDTO;
import com.meli.tucasita.model.RoomDTO;
import com.meli.tucasita.repository.IPropertyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static com.meli.tucasita.util.TestUtilGenerator.getAllDistricts;
import static com.meli.tucasita.util.TestUtilGenerator.getPropertyOk;


@ExtendWith(MockitoExtension.class)
class TestPropertyService {
    @Mock
    IPropertyRepository iPropertyRepository;

    @InjectMocks
    PropertyService propertyService;

    private PropertyDTO propertyDTO;

    @BeforeEach
    void setUp() {
        propertyDTO = getPropertyOk();
    }

    @Test
    void TestGetPropertyArea() {
        //Arrange
        String districtName = propertyDTO.getDistrict().getDistrictName();
        Mockito.when(iPropertyRepository.exists(districtName)).thenReturn(true);

        //Act
        ResponseDTO received = propertyService.getPropertyArea(propertyDTO);

        //Assert
        Assertions.assertEquals("Area total de la propiedad.", received.getMsg());
        Assertions.assertEquals(1200.0, received.getValue());
    }

    @Test
    void TestGetPropertyValue() {
        //Arrange
        String districtName = propertyDTO.getDistrict().getDistrictName();
        Mockito.when(iPropertyRepository.exists(districtName)).thenReturn(true);

        //Act
        ResponseDTO received = propertyService.getPropertyValue(propertyDTO);

        //Assert
        Assertions.assertEquals("Valor total de la propiedad.", received.getMsg());
        Assertions.assertEquals(62050.0, received.getValue());
    }

    @Test
    void TestGetBiggestRoom() {
        //Arrange
        String districtName = propertyDTO.getDistrict().getDistrictName();
        Mockito.when(iPropertyRepository.exists(districtName)).thenReturn(true);

        //Act
        RoomDTO received = propertyService.getBiggestRoom(propertyDTO);

        //Assert
        Assertions.assertEquals("Habitacion 1", received.getRoomName());
        Assertions.assertEquals(5.0, received.getRoomWidth());
        Assertions.assertEquals(5.0, received.getRoomLength());
    }

    @Test
    void TestGetRoomsArea() {
        //Arrange
        String districtName = propertyDTO.getDistrict().getDistrictName();
        Mockito.when(iPropertyRepository.exists(districtName)).thenReturn(true);
        ResponseDTO r1 = new ResponseDTO("Habitacion 1", 25.0);
        ResponseDTO r2 = new ResponseDTO("Habitacion 2", 16.0);

        List<ResponseDTO> expected = List.of(r1, r2);

        //Act
        List<ResponseDTO> received = propertyService.getRoomsArea(propertyDTO);

        //Assert
        Mockito.verify(iPropertyRepository, Mockito.atLeastOnce()).exists(districtName);
        Assertions.assertEquals(expected, received);
    }

    @Test
    void TestGetAllDistricts() {
        //Arrange
        Mockito.when(iPropertyRepository.getAllDistricts()).thenReturn(getAllDistricts());
        //Act
        Set<String> expected = getAllDistricts();
        Set<String> received = propertyService.getAllDistricts();
        //Arrange
        Mockito.verify(iPropertyRepository, Mockito.atLeastOnce()).getAllDistricts();
        Assertions.assertEquals(expected, received);
    }
}
