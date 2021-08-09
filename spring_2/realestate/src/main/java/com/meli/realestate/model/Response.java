package com.meli.realestate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Response {
    private double propertyArea;
    private double propertyValue;
    private Room biggestRoom;
    private List<Room> rooms;
}
