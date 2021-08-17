package com.meli.tucasita.repository;

import java.util.Set;

public interface IPropertyRepository {
    boolean exists(String districtName);

    Set<String> getAllDistricts();
}
