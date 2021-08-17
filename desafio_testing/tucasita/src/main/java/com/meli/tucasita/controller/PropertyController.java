package com.meli.tucasita.controller;

import com.meli.tucasita.model.PropertyDTO;
import com.meli.tucasita.model.ResponseDTO;
import com.meli.tucasita.model.RoomDTO;
import com.meli.tucasita.service.IPropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class PropertyController {

    private final IPropertyService service;

    @PostMapping("/property/area")
    public ResponseEntity<ResponseDTO> calculatePropertyArea(@Valid @RequestBody PropertyDTO property) {
        return new ResponseEntity<>(service.getPropertyArea(property), HttpStatus.OK);
    }

    @PostMapping("/property/value")
    public ResponseEntity<ResponseDTO> calculatePropertyValue(@Valid @RequestBody PropertyDTO property) {
        return new ResponseEntity<>(service.getPropertyValue(property), HttpStatus.OK);
    }

    @PostMapping("/rooms/biggest")
    public ResponseEntity<RoomDTO> calculateBiggestRoom(@Valid @RequestBody PropertyDTO property) {
        return new ResponseEntity<>(service.getBiggestRoom(property), HttpStatus.OK);
    }

    @PostMapping("/rooms/area")
    public ResponseEntity<List<ResponseDTO>> calculateRoomsArea(@Valid @RequestBody PropertyDTO property) {
        return new ResponseEntity<>(service.getRoomsArea(property), HttpStatus.OK);
    }

    @GetMapping("/districts")
    public ResponseEntity<Set<String>> getAllDistricts() {
        return new ResponseEntity<>(service.getAllDistricts(), HttpStatus.OK);
    }
}
