package com.justin.springbootmall;

import com.justin.springbootmall.jpa.relationship.entity.Student;
import com.justin.springbootmall.jpa.relationship.dao.StudentDAO;
import com.justin.springbootmall.utils.StudentUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringbootmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootmallApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner -> { // will be executed right after the service started

//            createStudent(studentDAO);

//            createStudents(studentDAO);

//            readStudent(studentDAO); // query one

            // query many
//            queryForStudents(studentDAO);

            // query by name
//            queryForStudentsByName(studentDAO, "Omer Moore");

//            updateStudent(studentDAO);

//            deleteStudent(studentDAO);

//            deleteAllStudent(studentDAO);
        };
    }

    private void deleteAllStudent(StudentDAO studentDAO) {
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("numRowsDeleted: " + numRowsDeleted);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        Long studentId = 7L;
        studentDAO.delete(studentId);
        System.out.println("deleted student id: "+studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        Student student7 = studentDAO.findById(7L);
        System.out.println("student7: "+student7);
        student7.setName("Kaede Rukawa");
        studentDAO.update(student7);
        Student updatedStudent7 = studentDAO.findById(7L);
        System.out.println("updatedStudent7: "+updatedStudent7);
    }

    private void queryForStudentsByName(StudentDAO studentDAO, String name) {
        List<Student> byName = studentDAO.findByName(name);
        System.out.println(byName);
    }


    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();
        for (Student student: students){
            System.out.println(student);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        Student student = StudentUtils.createOneStudent();
        studentDAO.save(student);
        System.out.println("student saved: "+student);
        Student studentFromDB = studentDAO.findById(student.getId());
        System.out.println("student from DB: "+studentFromDB);
    }

    private void createStudents(StudentDAO studentDAO) {

        // create multiple students
        ArrayList<Student> students = StudentUtils.createStudentList(5);

        // save the student objects
        for (int i = 0; i < students.size(); i++) {
            studentDAO.save(students.get(i));
        }
    }

    private void createStudent(StudentDAO studentDAO) {
        // create object to save
        Student student = StudentUtils.createOneStudent();
        // save the object
        studentDAO.save(student);
        // display id of the saved student
        System.out.println("saved student. Generated id: " + student.getId());

    }

}
