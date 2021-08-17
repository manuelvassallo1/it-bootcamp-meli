package com.meli.tucasita.repository;

import com.meli.tucasita.util.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TestPropertyRepository {

    @InjectMocks
    PropertyRepository repository;

    @Test
    void TestDistrictExist() {
        Assertions.assertTrue(repository.exists("Saavedra"));
    }

    @Test
    void TestDistrictNotExists() {
        Assertions.assertFalse(repository.exists("La Ferrere"));
    }

    @Test
    void TestGetAllDistricts() {
        Assertions.assertEquals(TestUtilGenerator.getAllDistricts(), repository.getAllDistricts());
    }
}
