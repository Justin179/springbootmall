package com.justin.springbootmall.rest.controller;

import com.justin.springbootmall.jpa.relationship.entity.Student;
import com.justin.springbootmall.rest.entity.PlainStudent;
import com.justin.springbootmall.utils.StudentUtils;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<PlainStudent> plainStudents;
    // define @PostConstruct to load the student data only once when the given bean is constructed
    @PostConstruct
    public void loadData(){
        plainStudents = StudentUtils.createPlainStudents(5);
    }


    @GetMapping("/students")
    public List<PlainStudent> getStudents(){
//        List<PlainStudent> plainStudents = StudentUtils.createPlainStudents(5);
        return plainStudents;

    }

    @GetMapping("/students/{studentId}")
    public PlainStudent getStudent(@PathVariable int studentId){
//        List<PlainStudent> plainStudents = StudentUtils.createPlainStudents(5);
        return plainStudents.get(studentId);
    }

}
