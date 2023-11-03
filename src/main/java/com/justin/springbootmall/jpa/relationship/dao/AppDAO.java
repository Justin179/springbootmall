package com.justin.springbootmall.jpa.relationship.dao;

import com.justin.springbootmall.jpa.relationship.entity.Course;
import com.justin.springbootmall.jpa.relationship.entity.Instructor;
import com.justin.springbootmall.jpa.relationship.entity.InstructorDetail;
import com.justin.springbootmall.jpa.relationship.entity.Student;
import org.springframework.transaction.annotation.Transactional;

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



    Course findCourseAndReviewsByCourseId(int id);

    // from a course to students
    void save(Course course);
    Course findCourseAndStudentsByCourseId(int id);

    // from a student to courses
    void save(Student course);

    Student findStudentAndCoursesByStudentId(int id);
}
