package com.justin.springbootmall.jpa;

import com.justin.springbootmall.jpa.relationship.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/students")
    public String create(@RequestBody Student student){
        studentRepository.save(student);
        return "create student success";
    }

    @GetMapping("/students/{studentId}")
    public Student read(@PathVariable Long studentId){
        Student student = studentRepository.findById(studentId).orElse(null);
        return student;
    }

    @PutMapping("/students/{studentId}")
    public String update(@PathVariable Long studentId, @RequestBody Student student){

        Student existingStudent = studentRepository.findById(studentId).orElse(null);
        if (existingStudent !=null){
            existingStudent.setName(student.getName());
            existingStudent.setAge(student.getAge());
            existingStudent.setEmail(student.getEmail());
            studentRepository.save(existingStudent);
            return "update student success"; // insert if not exist
        }

        return "student id: " + studentId + "doesn't exist";
    }

    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Long studentId){

        studentRepository.deleteById(studentId);
        return "delete student success";
    }



}
















