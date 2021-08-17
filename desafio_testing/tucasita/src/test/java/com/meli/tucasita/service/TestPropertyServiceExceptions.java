package com.meli.tucasita.service;

import com.meli.tucasita.exceptions.NoSuchDistrictException;
import com.meli.tucasita.exceptions.WrongRoomsSizeException;
import com.meli.tucasita.model.PropertyDTO;
import com.meli.tucasita.repository.IPropertyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.meli.tucasita.util.TestUtilGenerator.getPropertyWithWrongDistrict;
import static com.meli.tucasita.util.TestUtilGenerator.getPropertyWithWrongRoomSize;

@ExtendWith(MockitoExtension.class)
class TestPropertyServiceExceptions {
    @Mock
    IPropertyRepository iPropertyRepository;

    @InjectMocks
    PropertyService propertyService;

    @Test
    void TestWrongRoomsSizeException() {
        //Arrange
        PropertyDTO propertyDTO = getPropertyWithWrongRoomSize();
        String districtName = propertyDTO.getDistrict().getDistrictName();
        Mockito.when(iPropertyRepository.exists(districtName)).thenReturn(true);

        //Act
        //Assert
        Assertions.assertThrows(WrongRoomsSizeException.class, () -> propertyService.getPropertyArea(propertyDTO));
    }

    @Test
    void TestWrongDistrict() {
        //Arrange
        PropertyDTO propertyDTO = getPropertyWithWrongDistrict();
        String districtName = propertyDTO.getDistrict().getDistrictName();
        Mockito.when(iPropertyRepository.exists(districtName)).thenReturn(false);

        //Act
        //Assert
        Assertions.assertThrows(NoSuchDistrictException.class, () -> propertyService.getPropertyArea(propertyDTO));
    }
}
