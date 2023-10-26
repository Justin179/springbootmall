package com.justin.springbootmall.jpa;

import com.justin.springbootmall.utils.StudentUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentIdCardRepository studentIdCardRepository;

    @BeforeEach
    void beforeEach(){
        studentIdCardRepository.deleteAll(); // 要先刪有外鍵的那個
        studentRepository.deleteAll(); // 才能刪另一個
    }


    @Test
    void studentRepository(){
        // test one on one relationship
        Student student = StudentUtils.createOneStudent();
        StudentIdCard studentIdCard = new StudentIdCard("123456789", student);
        studentIdCardRepository.save(studentIdCard);

        studentRepository.deleteAll();
    }
}