package com.meli.tucasita.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Repository
public class PropertyRepository implements IPropertyRepository {
    private static final String DB_PATH = "classpath:districts.json";
    private Set<String> districts = new HashSet<>();

    public PropertyRepository() {
        File file = null;
        try {
            file = ResourceUtils.getFile(DB_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<Set<String>> typeRef = new TypeReference<>() {
        };

        try {
            districts = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean exists(String districtName) {
        return districts.contains(districtName);
    }

    @Override
    public Set<String> getAllDistricts() {
        return districts;
    }
}
