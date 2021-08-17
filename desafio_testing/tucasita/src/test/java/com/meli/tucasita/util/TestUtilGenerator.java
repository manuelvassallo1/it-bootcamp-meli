package com.meli.tucasita.util;

import com.meli.tucasita.model.DistrictDTO;
import com.meli.tucasita.model.PropertyDTO;
import com.meli.tucasita.model.RoomDTO;

import java.util.List;
import java.util.Set;

public class TestUtilGenerator {
    public static List<RoomDTO> getRooms() {
        RoomDTO room1 = new RoomDTO("Habitacion 1", 5.0, 5.0);
        RoomDTO room2 = new RoomDTO("Habitacion 2", 4.0, 4.0);

        return List.of(room1, room2);
    }

    public static PropertyDTO getPropertyOk() {
        return PropertyDTO.builder()
                .propName("Espacio1")
                .propLandLength(30.0)
                .propLandWidth(40.0)
                .district(getDistrictOk())
                .rooms(getRooms())
                .build();
    }

    public static PropertyDTO getPropertyWithWrongDistrict() {
        return PropertyDTO.builder()
                .propName("Espacio1")
                .propLandLength(30.0)
                .propLandWidth(40.0)
                .district(getWrongDistrict())
                .rooms(getRooms())
                .build();
    }

    public static PropertyDTO getPropertyWithWrongRoomSize() {
        return PropertyDTO.builder()
                .propName("Espacio1")
                .propLandLength(3.0)
                .propLandWidth(4.0)
                .district(getDistrictOk())
                .rooms(getRooms())
                .build();
    }

    public static PropertyDTO getPropertyWithWrongFields() {
        RoomDTO r1 = RoomDTO.builder()
                .roomName("habitacion")
                .roomWidth(100.0)
                .roomLength(100.0)
                .build();

        RoomDTO r2 = RoomDTO.builder()
                .roomName("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
                .roomWidth(0.0)
                .build();

        List<RoomDTO> rooms = List.of(r1, r2);

        DistrictDTO district = DistrictDTO.builder()
                .districtName("Belgrano")
                .districtBuiltPrice(4001.0)
                .districtUnbuiltPrice(1001.0)
                .build();


        return PropertyDTO.builder()
                .propName("espacio1")
                .propLandWidth(100.0)
                .propLandLength(-1.0)
                .district(district)
                .rooms(rooms)
                .build();
    }

    private static DistrictDTO getDistrictOk() {
        return DistrictDTO.builder()
                .districtName("Saavedra")
                .districtBuiltPrice(100.0)
                .districtUnbuiltPrice(50.0)
                .build();
    }

    private static DistrictDTO getWrongDistrict() {
        return DistrictDTO.builder()
                .districtName("La Ferrere")
                .districtBuiltPrice(100.0)
                .districtUnbuiltPrice(50.0)
                .build();
    }

    public static Set<String> getAllDistricts() {
        return Set.of("Belgrano",
                "Nueva Pompeya",
                "Balvanera",
                "Saavedra",
                "Villa del Parque",
                "Mataderos",
                "Villa Ortúzar",
                "Villa Urquiza",
                "Almagro",
                "Coghlan",
                "Liniers",
                "La Paternal",
                "Puerto Madero",
                "Caballito",
                "Palermo",
                "Recoleta",
                "Villa Luro",
                "Agronomía",
                "Monserrat",
                "San Nicolás",
                "Monte Castro",
                "Villa Crespo",
                "Parque Chacabuco",
                "Villa Pueyrredón",
                "Versalles",
                "San Cristóbal",
                "Villa General Mitre",
                "San Telmo",
                "Chacarita",
                "Parque Avellaneda",
                "Parque Chas",
                "Villa Soldati",
                "Flores",
                "Villa Riachuelo",
                "Colegiales",
                "Constitución",
                "La Boca",
                "Barracas",
                "Boedo",
                "Parque Patricios",
                "Villa Lugano",
                "Retiro",
                "Villa Santa Rita",
                "Villa Devoto",
                "Núñez",
                "Vélez Sársfield",
                "Villa Real");
    }
}
