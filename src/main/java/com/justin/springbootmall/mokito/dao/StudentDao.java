package com.justin.springbootmall.mokito.dao;


import com.justin.springbootmall.mokito.model.Student;

public interface StudentDao {

    Integer insert(Student student);

    void update(Student student);

    void deleteById(Integer id);

    Student getById(Integer id);
}
