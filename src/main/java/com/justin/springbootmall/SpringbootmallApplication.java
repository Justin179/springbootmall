package com.justin.springbootmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootmallApplication.class, args);
    }


//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
//        return args -> {
//            // will be executed right after the service started
//            Student student = studentRepository.findById(1L).orElse(null);
//            System.out.println(student);
//        };
//    }

}
