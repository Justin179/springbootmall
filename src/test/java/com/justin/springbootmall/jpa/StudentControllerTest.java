package com.justin.springbootmall.jpa;

import com.github.javafaker.Faker;
import com.justin.springbootmall.utils.StudentUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentControllerTest {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentJpaRepository studentJpaRepository;

    @BeforeEach
    void beforeEach(){
        studentRepository.deleteAll();
        System.out.println();
    }


    @Test
    void findStudentByEmail(){
        studentRepository.save(StudentUtils.createOneStudent("justin.uob"));
        Student student = studentRepository.findStudentByEmail("justin.uob@gmail.com").orElse(null);
        assertNotNull(student);
    }

    @Test
    void findStudentByNameEqualsAndAgeEquals(){
        Student student1 = StudentUtils.createOneStudent("justin", 41, "abcd@gmail.com");
        Student student2 = StudentUtils.createOneStudent("justin", 41, "1234@gmail.com");
        List<Student> students = Arrays.asList(student1, student2);
        studentRepository.saveAll(students);
        List<Student> studentList = studentRepository.findStudentByNameEqualsAndAgeEquals("justin", 41);
        assertEquals(2,studentList.size());
    }
    /*
        @Query("DELETE FROM Student u WHERE u.email = ?1")
    int deleteStudentByEmail(String email);
     */
    @Test
    void deleteStudentByEmail(){
        Student student1 = StudentUtils.createOneStudent("justin", 41, "abcd@gmail.com");
        Student student2 = StudentUtils.createOneStudent("justin", 41, "1234@gmail.com");
        List<Student> students = Arrays.asList(student1, student2);
        studentRepository.saveAll(students);
        studentRepository.deleteStudentByEmail("1234@gmail.com");
        assertEquals(1,studentRepository.count());
    }

//    @Test
//    void findStudentByNameEqualsAndAgeEquals(){
//        Student student1 = createOneStudent("justin", 41, "abcd@gmail.com");
//        Student student2 = createOneStudent("justin", 41, "1234@gmail.com");
//        List<Student> students = Arrays.asList(student1, student2);
//        studentRepository.saveAll(students);
//        List<Student> studentList = studentRepository.findStudentByNameEqualsAndAgeEquals("justin", 41);
//        assertEquals(2,studentList.size());
//    }
//    //     List<Student> findStudentByNameEqualsAndAgeEquals(@Param("name") String name, @Param("age") Integer age);

    @Test
    void saveAll(){
        ArrayList<Student> students = StudentUtils.createStudentList(10);
        studentRepository.saveAll(students);
        assertEquals(10L, studentRepository.count());
    }

    @Test
    void sorting(){
        ArrayList<Student> studentList = StudentUtils.createStudentList(10);
        studentRepository.saveAll(studentList);
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        List<Student> students = studentJpaRepository.findAll(sort);
        students.stream().forEach(student -> System.out.println(student.getName()));
    }

    @Test
    void pagingAndSorting(){
        ArrayList<Student> studentList = StudentUtils.createStudentList(20);
        studentRepository.saveAll(studentList);
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        PageRequest pageRequest = PageRequest.of(0, 5, sort);
        Page<Student> page = studentJpaRepository.findAll(pageRequest);
        System.out.println(page);
    }


}












