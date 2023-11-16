package com.justin.springbootmall.mokito.service;


import com.justin.springbootmall.mokito.model.Student;

public interface StudentService {

    Integer insert(Student student);

    void update(Student student);

    void deleteById(Integer id);

    Student getById(Integer id);
}
