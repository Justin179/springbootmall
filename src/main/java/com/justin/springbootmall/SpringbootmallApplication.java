package com.justin.springbootmall;

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
    CommandLineRunner commandLineRunner(){
        return runner -> { // will be executed right after the service started
            System.out.println("this is commandLineRunner()");
        };
    }



}
