package com.justin.springbootmall;

import com.justin.springbootmall.jpa.StudentRepository;
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
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return runner -> {
            // will be executed right after the service started
//            Student student = studentRepository.findById(1L).orElse(null);
            System.out.println("this is commandLineRunner");
        };
    }

}
