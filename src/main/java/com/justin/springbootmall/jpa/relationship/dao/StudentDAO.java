package com.justin.springbootmall.jpa.relationship.dao;

import com.justin.springbootmall.jpa.relationship.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(Long id);

    List<Student> findAll();
}
