package com.justin.springbootmall.jpa;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentControllerTest {

    @Autowired
    StudentRepository studentRepository;

    @BeforeEach
    void beforeEach(){
        studentRepository.deleteAll();
    }


    @Test
    void findStudentByEmail(){
        studentRepository.save(createOneStudent("justin.uob"));
        Student student = studentRepository.findStudentByEmail("justin.uob@gmail.com").orElse(null);
        assertNotNull(student);
    }

    @Test
    void findStudentByNameEqualsAndAgeEquals(){
        Student student1 = createOneStudent("justin", 41, "abcd@gmail.com");
        Student student2 = createOneStudent("justin", 41, "1234@gmail.com");
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
        Student student1 = createOneStudent("justin", 41, "abcd@gmail.com");
        Student student2 = createOneStudent("justin", 41, "1234@gmail.com");
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
        ArrayList<Student> students = createStudentList(10);
        studentRepository.saveAll(students);
        assertEquals(10L, studentRepository.count());
    }



    private Student createOneStudent(String name) {
        Faker faker = new Faker();
        String email = String.format("%s@gmail.com", name);
        Integer age = faker.number().numberBetween(18, 40);
        Student student = new Student(name, email, age);
        return student;
    }

    private Student createOneStudent(String name, Integer age) {
        Faker faker = new Faker();
        String email = String.format("%s@gmail.com", name);
        Student student = new Student(name, email, age);
        return student;
    }

    private Student createOneStudent(String name, Integer age, String email) {
        Student student = new Student(name, email, age);
        return student;
    }

    private Student createOneStudent() {
        Faker faker = new Faker();
        String name = faker.name().name();
        String email = String.format("%s@gmail.com", name);
        Integer age = faker.number().numberBetween(18, 40);
        Student student = new Student(name, email, age);
        return student;
    }

    private ArrayList<Student> createStudentList(int quantity) {
        ArrayList<Student> students = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < quantity; i++) {
            String name = faker.name().name();
            String email = String.format("%s@gmail.com", name);
            Integer age = faker.number().numberBetween(18,40);
            Student student = new Student(name, email, age);
            students.add(student);
        }
        return students;
    }

}












