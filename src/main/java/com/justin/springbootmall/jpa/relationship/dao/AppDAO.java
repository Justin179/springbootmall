package com.justin.springbootmall.jpa.relationship.dao;

import com.justin.springbootmall.jpa.relationship.entity.Course;
import com.justin.springbootmall.jpa.relationship.entity.Instructor;
import com.justin.springbootmall.jpa.relationship.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void deleteInstructorById(int id);

    void deleteCourseById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);

    void update(Instructor instructor);

    void update(Course course);

    Course findCourseById(int id);

    void save(Course course);

}
