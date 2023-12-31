package com.justin.springbootmall.mokito.service;

import com.justin.springbootmall.mokito.dao.StudentDao;
import com.justin.springbootmall.mokito.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Integer insert(Student student) {
        return studentDao.insert(student);
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    public void deleteById(Integer id) {
        studentDao.deleteById(id);
    }

    @Override
    public Student getById(Integer id) {
        return studentDao.getById(id);
    }
}
