package com.justin.springbootmall.jpa.relationship.dao;

import com.justin.springbootmall.jpa.relationship.Instructor;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);
}
