package com.justin.springbootmall.thymeleaf;

import com.justin.springbootmall.resttemplate.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ThymeleafController {

    @GetMapping("/home")
    public String home(Model model){

        Teacher teacher = new Teacher();
        teacher.setName("judy");
        model.addAttribute("teacher",teacher);

        return "index";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping("/login")
    public String login(String userName,
                        String userPassword) {

        System.out.println("userName 為: " + userName);
        System.out.println("userPassword 為: " + userPassword);

        return "login";
    }
}













