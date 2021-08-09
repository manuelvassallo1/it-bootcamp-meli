package com.meli.realestate.controller;

import com.meli.realestate.model.RealEstateProperty;
import com.meli.realestate.model.Response;
import com.meli.realestate.model.Room;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RealEstateController {

    private static final double SQM_VALUE = 800;
    private Room biggestRoom = null;

    @PostMapping("/realEstate")
    public Response getPropertyData(@RequestBody RealEstateProperty realEstateProperty) {

        double propertyArea = getPropertyArea(realEstateProperty.getRooms());
        double propertyValue = calculateArea(SQM_VALUE, propertyArea);

        return new Response(propertyArea, propertyValue, biggestRoom, realEstateProperty.getRooms());
    }

    private double getPropertyArea(List<Room> rooms) {
        return rooms.stream()
                .mapToDouble(this::getArea)
                .sum();
    }

    private double getArea(Room room) {
        double area = calculateArea(room.getLenght(), room.getWidth());
        room.setArea(area);

        if (biggestRoom != null) {
            if (room.getArea() > biggestRoom.getArea()) {
                biggestRoom = room;
            }
        } else {
            biggestRoom = room;
        }
        return area;
    }

    private double calculateArea(double lenght, double width) {
        return lenght * width;
    }
}
