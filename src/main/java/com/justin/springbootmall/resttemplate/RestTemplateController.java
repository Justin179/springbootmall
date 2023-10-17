package com.justin.springbootmall.resttemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestTemplateController {

    @GetMapping("/getForObject")
    public String getForObject(){

        RestTemplate restTemplate = new RestTemplate();

        // 傳過去的請求參數
        HashMap<String, Object> queryParam = new HashMap<>();
        queryParam.put("graduate", true);

        Teacher forObject = restTemplate.getForObject(
                "https://mocki.io/v1/73f91079-45b7-423c-9bb9-b714a1c7725d",
                Teacher.class,
                queryParam);

        System.out.println(forObject); // 會變這樣: com.justin.springbootmall.resttemplate.Teacher@19c92fcb
        System.out.println(forObject.getId());
        System.out.println(forObject.getName());
        System.out.println(forObject.getContactPhone());


        return "called getForObject()";
    }


    @GetMapping("/getForEntity")
    public String getForEntity(){

        RestTemplate restTemplate = new RestTemplate();

        // 傳過去的請求參數
        HashMap<String, Object> queryParam = new HashMap<>();
        queryParam.put("graduate", true);

        // ResponseEntity裡面的資訊比較多，像是請求的狀態碼, header...
        ResponseEntity<Teacher> forEntity = restTemplate.getForEntity(
                "https://mocki.io/v1/73f91079-45b7-423c-9bb9-b714a1c7725d",
                Teacher.class,
                queryParam);

        Teacher teacher = forEntity.getBody();
        System.out.println(teacher); // 會變這樣: com.justin.springbootmall.resttemplate.Teacher@19c92fcb
        System.out.println(teacher.getId());
        System.out.println(teacher.getName());
        System.out.println(teacher.getContactPhone());


        return "called getForEntity()";
    }


    @GetMapping("/postForObject")
    public String postForObject(){

        RestTemplate restTemplate = new RestTemplate();

        // 傳過去的請求參數
        Teacher teacher = new Teacher();
        teacher.setName("Justin");

        Teacher forObject = restTemplate.postForObject(
                "https://mocki.io/v1/73f91079-45b7-423c-9bb9-b714a1c7725d",
                teacher,
                Teacher.class);

        System.out.println(forObject); // 會變這樣: com.justin.springbootmall.resttemplate.Teacher@19c92fcb
        System.out.println(forObject.getId());
        System.out.println(forObject.getName());
        System.out.println(forObject.getContactPhone());


        return "called postForObject()";
    }

    @GetMapping("/postForEntity")
    public String postForEntity(){

        RestTemplate restTemplate = new RestTemplate();

        // 傳過去的請求參數
        Teacher teacher = new Teacher();
        teacher.setName("Justin");

        ResponseEntity<Teacher> entity = restTemplate.postForEntity(
                "https://mocki.io/v1/73f91079-45b7-423c-9bb9-b714a1c7725d",
                teacher,
                Teacher.class);

        Teacher body = entity.getBody();

        System.out.println(body); // 會變這樣: com.justin.springbootmall.resttemplate.Teacher@19c92fcb
        System.out.println(body.getId());
        System.out.println(body.getName());
        System.out.println(body.getContactPhone());

        return "called postForEntity()";
    }

    // 這個是最強大的
    @GetMapping("/exchange")
    public String exchange() {

        RestTemplate restTemplate = new RestTemplate();

        // 使用 exchange 發起 GET 請求
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("header1", "123");

        // header放在entity裡面
        HttpEntity requestEntity = new HttpEntity(requestHeaders);

        // 請求參數
        Map<String, Object> queryParamMap = new HashMap<>();
        queryParamMap.put("graduate", true);

        ResponseEntity<Teacher> getStudentEntity = restTemplate.exchange(
                "https://mocki.io/v1/b7a68eb2-f77c-43cf-bffe-8c647e9a2514",
                HttpMethod.GET,
                requestEntity,
                Teacher.class,
                queryParamMap
        );



        // 使用 exchange 發起 POST 請求
        HttpHeaders requestHeaders2 = new HttpHeaders();
        requestHeaders2.set("header2", "456");
        requestHeaders2.setContentType(MediaType.APPLICATION_JSON);

        // 請求參數
        Teacher studentRequestBody = new Teacher();
        studentRequestBody.setName("John");

        // 請求參數與header放在entity裡面
        HttpEntity requestEntity2 = new HttpEntity(studentRequestBody, requestHeaders2);

        ResponseEntity<Teacher> postStudentEntity = restTemplate.exchange(
                "https://mocki.io/v1/b7a68eb2-f77c-43cf-bffe-8c647e9a2514",
                HttpMethod.POST,
                requestEntity2,
                Teacher.class
        );

        return "exchange success";
    }



















}
