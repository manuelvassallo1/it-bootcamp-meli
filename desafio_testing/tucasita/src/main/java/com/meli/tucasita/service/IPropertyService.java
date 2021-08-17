package com.meli.tucasita.service;

import com.meli.tucasita.model.PropertyDTO;
import com.meli.tucasita.model.ResponseDTO;
import com.meli.tucasita.model.RoomDTO;

import java.util.List;
import java.util.Set;

public interface IPropertyService {
    ResponseDTO getPropertyArea(PropertyDTO propertyDTO);

    ResponseDTO getPropertyValue(PropertyDTO propertyDTO);

    RoomDTO getBiggestRoom(PropertyDTO propertyDTO);

    List<ResponseDTO> getRoomsArea(PropertyDTO propertyDTO);

    Set<String> getAllDistricts();
}
