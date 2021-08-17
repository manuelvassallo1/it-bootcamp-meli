package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilGenerator;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestStudentDAO {
    IStudentDAO iStudentDAO;

    @BeforeEach
    private void setUp() {
        iStudentDAO = new StudentDAO();
    }

    @Test
    @Order(1)
    void TestSaveStudent() {
        StudentDTO student = TestUtilGenerator.getStudents().get(0);
        iStudentDAO.save(student);
        Assertions.assertTrue(iStudentDAO.exists(student));
    }

    @Test
    @Order(2)
    void TestSaveNullStudent() {
        Assertions.assertThrows(NullPointerException.class, () -> iStudentDAO.save(null));
    }

    @Test
    @Order(3)
    void TestFindById() {
        Assertions.assertEquals("Juan", iStudentDAO.findById(1L).getStudentName());
    }

    @Test
    @Order(4)
    void TestUpdateStudent() {
        StudentDTO stu = iStudentDAO.findById(3L);
        stu.setStudentName("Juan Carlos");
        iStudentDAO.save(stu);
        Assertions.assertEquals("Juan Carlos", iStudentDAO.findById(3L).getStudentName());
    }

    @Test
    @Order(5)
    void TestDeleteStudent() {
        Assertions.assertTrue(iStudentDAO.delete(3L));
    }
}
