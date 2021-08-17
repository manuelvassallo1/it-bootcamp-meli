package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class TestStudentRepository {
    IStudentRepository iStudentRepository;
    IStudentDAO iStudentDAO;

    @BeforeEach
    private void setUp() {
        iStudentRepository = new StudentRepository();
        iStudentDAO = new StudentDAO();
    }

    @Test
    void TestFindAllStudents() {
        Set<StudentDTO> stu = new HashSet<>();
        stu.add(iStudentDAO.findById(1L));
        stu.add(iStudentDAO.findById(2L));

        Set<StudentDTO> students = iStudentRepository.findAll();

        List<String> names = stu.stream()
                .map(StudentDTO::getStudentName)
                .collect(Collectors.toList());

        students.forEach(s -> Assertions.assertTrue(names.contains(s.getStudentName())));
    }
}
