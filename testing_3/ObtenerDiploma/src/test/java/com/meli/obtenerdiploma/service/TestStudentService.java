package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.util.TestUtilGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TestStudentService {
    @Mock
    IStudentDAO iStudentDAO;
    @Mock
    IStudentRepository iStudentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    void TestCreateStudent() {
        StudentDTO stu = TestUtilGenerator.getStudents().get(0);
        Mockito.doNothing().when(iStudentDAO).save(stu);

        studentService.create(stu);

        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).save(stu);
    }

    @Test
    void TestReadStudent() {
        final long id = 1L;
        studentService.read(id);
        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).findById(id);
    }

    @Test
    void TestUpdateStudent() {
        StudentDTO expected = TestUtilGenerator.getStudents().get(0);
        studentService.update(expected);
        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).save(expected);
    }

    @Test
    void TestDeleteStudent() {
        final long id = 1L;
        studentService.delete(id);
        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).delete(id);
    }

    @Test
    void TestGetAllStudents() {
        studentService.getAll();
        Mockito.verify(iStudentRepository, Mockito.atLeastOnce()).findAll();
    }
}
