package com.meli.obtenerdiploma.util;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.ArrayList;
import java.util.List;

public class TestUtilGenerator {
    public static List<StudentDTO> getStudents() {
        List<StudentDTO> students = new ArrayList<>();
        List<SubjectDTO> subjects = new ArrayList<>();
        List<SubjectDTO> subjects2 = new ArrayList<>();

        SubjectDTO sub1 = new SubjectDTO("Matematica", 7.0);
        SubjectDTO sub2 = new SubjectDTO("Lengua", 9.0);
        SubjectDTO sub3 = new SubjectDTO("Fisica", 9.0);
        SubjectDTO sub4 = new SubjectDTO("Biologia", 9.0);

        subjects.add(sub1);
        subjects.add(sub2);
        subjects2.add(sub3);
        subjects2.add(sub4);
        StudentDTO st1 = new StudentDTO(3L, "Manuel", null, null, subjects);
        StudentDTO st2 = new StudentDTO(4L, "Camila", null, null, subjects2);

        students.add(st1);
        students.add(st2);

        return students;
    }

    public static List<SubjectDTO> getSubjects() {
        SubjectDTO sub1 = new SubjectDTO("Matemática", 9.0);
        SubjectDTO sub2 = new SubjectDTO("Física", 7.0);
        SubjectDTO sub3 = new SubjectDTO("Química", 6.0);
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(sub1);
        subjects.add(sub2);
        subjects.add(sub3);
        return subjects;
    }
}
