package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TestStudentController {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    void TestRegisterStudent() {
        StudentDTO stu = new StudentDTO();
        studentController.registerStudent(stu);
        verify(studentService, atLeastOnce()).create(stu);
    }

    @Test
    void TestGetStudent() {
        final long id = 1L;
        studentController.getStudent(id);
        verify(studentService, atLeastOnce()).read(id);
    }

    @Test
    void TestModifyStudent() {
        StudentDTO stu = new StudentDTO();
        studentController.modifyStudent(stu);
        verify(studentService, atLeastOnce()).update(stu);
    }

    @Test
    void TestRemoveStudent() {
        final long id = 1L;
        studentController.removeStudent(id);
        verify(studentService, atLeastOnce()).delete(id);
    }

    @Test
    void TestListStudents() {
        studentController.listStudents();
        verify(studentService, atLeastOnce()).getAll();
    }
}
