package com.justin.springbootmall.rest.controller;

import com.justin.springbootmall.jpa.relationship.entity.Student;
import com.justin.springbootmall.rest.entity.PlainStudent;
import com.justin.springbootmall.rest.exception.StudentErrorResponse;
import com.justin.springbootmall.rest.exception.StudentNotFoundException;
import com.justin.springbootmall.utils.StudentUtils;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException studentNotFoundException){
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(studentNotFoundException.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    List<PlainStudent> plainStudents;
    // define @PostConstruct to load the student data only once when the given bean is constructed
    @PostConstruct
    public void loadData(){
        plainStudents = StudentUtils.createPlainStudents(5);
    }


    @GetMapping("/students")
    public List<PlainStudent> getStudents(){
        return plainStudents;

    }

    @GetMapping("/students/{studentId}")
    public PlainStudent getStudent(@PathVariable int studentId){

        if(studentId>=plainStudents.size() || studentId<0){
            throw new StudentNotFoundException("student id not found, id:"+studentId);
        }

        return plainStudents.get(studentId);
    }

}
