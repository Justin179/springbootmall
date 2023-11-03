package com.justin.springbootmall.jpa.relationship.dao;

import com.justin.springbootmall.jpa.relationship.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByName(String name);

    void update(Student student);

    void delete(int id);

    int deleteAll();
}
