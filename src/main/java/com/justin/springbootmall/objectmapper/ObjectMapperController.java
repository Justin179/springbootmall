package com.justin.springbootmall.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObjectMapperController {

    @GetMapping("/convert")
    public String convert() throws JsonProcessingException {

        // Student to json string
        Student student = new Student();
        student.setId(1);
        student.setName("Judy");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(student);
        System.out.println("json: "+json);

        // json string to Student
        String jsonStr = "{\"id\":3,\"name\":\"Amy\"}";
        Student studentObj = mapper.readValue(jsonStr, Student.class);
        System.out.println("Student id & name: "+studentObj.getId()+" & "+studentObj.getName());

        return "convert success";
    }

}
