package com.justin.springbootmall;

import com.justin.springbootmall.jpa.relationship.entity.Student;
import com.justin.springbootmall.jpa.relationship.dao.StudentDAO;
import com.justin.springbootmall.utils.StudentUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootmallApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner -> {
            // will be executed right after the service started
//            Student student = studentRepository.findById(1L).orElse(null);
            Student student = StudentUtils.createOneStudent();
            studentDAO.save(student);

            System.out.println("student just been saved: " + student);
        };
    }

}
