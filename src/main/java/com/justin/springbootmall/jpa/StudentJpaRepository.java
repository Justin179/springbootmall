package com.justin.springbootmall.jpa;

import com.justin.springbootmall.jpa.relationship.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentJpaRepository extends JpaRepository<Student,Long> {

    List<Student> findByName(String name);

    Student findByIdAndName(Integer id, String name);

    @Query(value = "SELECT id, name FROM student WHERE id = ?1 AND name = ?2", nativeQuery = true)
    Student findByIdAndNameNativeQuery(Integer id, String name);
}
