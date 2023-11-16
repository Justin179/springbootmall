package com.justin.springbootmall.mokito.service;

import com.justin.springbootmall.mokito.dao.StudentDao;
import com.justin.springbootmall.mokito.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceImplTest {

    @Autowired
    private StudentService studentService;

    @MockBean // 注入假bean
    private StudentDao studentDao; // 在這個類別的所有測試，都會拿到這個假的dao
    // 這個dao的影響範圍就是這個類別，每一個測試用的class都會有自己的spring container

    @BeforeEach
    public void beforeEach(){
        // mocking dao
        Student mockStudent = new Student();
        mockStudent.setId(100);
        mockStudent.setName("Mock");

        Mockito.when(studentDao.getById(Mockito.anyInt() )).thenReturn(mockStudent);
    }

    @Test
    public void getById(){
        Student student = studentService.getById(3);
        assertNotNull(student);
        assertEquals("Mock",student.getName());
    }

    @Test
    public void getById2(){
        Student student = studentService.getById(2);
        assertNotNull(student);
        assertEquals("Mock",student.getName());
    }
}