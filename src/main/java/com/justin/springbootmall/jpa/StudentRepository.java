package com.justin.springbootmall.jpa;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student,Long> {

    List<Student> findByName(String name);

    Student findByIdAndName(Integer id, String name);

    // Native SQL
    @Query(value = "SELECT id, name FROM student WHERE id = ?1 AND name = ?2", nativeQuery = true)
    Student findByIdAndNameNativeQuery(Integer id, String name);

    // JPQL
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

    // Native SQL (Named Parameters)
    @Query(value = "SELECT * FROM student WHERE name = :name AND age = :age", nativeQuery = true)
    List<Student> findStudentByNameEqualsAndAgeEquals(@Param("name") String name, @Param("age") Integer age);

    @Transactional
    @Modifying // tell spring no mapping is needed
    @Query("DELETE FROM Student u WHERE u.email = ?1")
    int deleteStudentByEmail(String email);
}
