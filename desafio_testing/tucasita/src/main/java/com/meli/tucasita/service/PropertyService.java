package com.meli.tucasita.service;

import com.meli.tucasita.exceptions.NoSuchDistrictException;
import com.meli.tucasita.exceptions.WrongRoomsSizeException;
import com.meli.tucasita.model.PropertyDTO;
import com.meli.tucasita.model.ResponseDTO;
import com.meli.tucasita.model.RoomDTO;
import com.meli.tucasita.repository.IPropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PropertyService implements IPropertyService {

    private final IPropertyRepository iPropertyRepository;

    @Override
    public ResponseDTO getPropertyArea(PropertyDTO propertyDTO) {
        validateProperty(propertyDTO);
        return new ResponseDTO("Area total de la propiedad.", propertyDTO.getPropertyArea());
    }

    @Override
    public ResponseDTO getPropertyValue(PropertyDTO propertyDTO) {
        validateProperty(propertyDTO);
        double roomsTotalArea = propertyDTO.getRoomsTotalArea();
        double propertyArea = propertyDTO.getPropertyArea();
        double unbuiltValue = (propertyArea - roomsTotalArea) * propertyDTO.getDistrict().getDistrictUnbuiltPrice();
        double builtValue = roomsTotalArea * propertyDTO.getDistrict().getDistrictBuiltPrice();

        return new ResponseDTO("Valor total de la propiedad.", unbuiltValue + builtValue);
    }

    @Override
    public RoomDTO getBiggestRoom(PropertyDTO propertyDTO) {
        validateProperty(propertyDTO);
        return propertyDTO.getRooms()
                .stream()
                .max(Comparator.comparing(r -> getArea(r.getRoomLength(), r.getRoomWidth())))
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<ResponseDTO> getRoomsArea(PropertyDTO propertyDTO) {
        validateProperty(propertyDTO);
        return propertyDTO.getRooms()
                .stream()
                .map(r -> ResponseDTO.builder()
                        .msg(r.getRoomName())
                        .value(getArea(r.getRoomLength(), r.getRoomWidth()))
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public Set<String> getAllDistricts() {
        return iPropertyRepository.getAllDistricts();
    }

    private double getRoomsTotalArea(PropertyDTO propertyDTO) {
        return propertyDTO.getRooms()
                .stream()
                .mapToDouble(r -> getArea(r.getRoomLength(), r.getRoomWidth()))
                .sum();
    }

    private double getArea(double a, double b) {
        return a * b;
    }

    private void validateProperty(PropertyDTO propertyDTO) {
        String districtName = propertyDTO.getDistrict().getDistrictName();
        if (!iPropertyRepository.exists(districtName)) {
            throw new NoSuchDistrictException(districtName);
        }
        double roomsTotalArea = getRoomsTotalArea(propertyDTO);
        double propertyArea = getArea(propertyDTO.getPropLandLength(), propertyDTO.getPropLandWidth());
        if (roomsTotalArea > propertyArea) {
            throw new WrongRoomsSizeException();
        }
        propertyDTO.setPropertyArea(propertyArea);
        propertyDTO.setRoomsTotalArea(roomsTotalArea);
    }
}
