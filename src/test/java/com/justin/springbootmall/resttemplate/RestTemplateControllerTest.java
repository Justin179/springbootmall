package com.justin.springbootmall.resttemplate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RestTemplateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getForObject() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/getForObject");
        /* String json
        {
            "id": 123,
            "name": "Allen",
            "contact_phone": "999"
        }
         */
        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", equalTo(123)))
                .andExpect(jsonPath("$.name", equalTo("Allen")))
                .andExpect(jsonPath("$.contact_phone", equalTo("999")));
    }

    @Test
    void getForEntity() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/getForEntity");
        /* String json
        {
            "id": 123,
            "name": "Allen",
            "contact_phone": "999"
        }
         */
        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", equalTo(123)))
                .andExpect(jsonPath("$.name", equalTo("Allen")))
                .andExpect(jsonPath("$.contact_phone", equalTo("999")));
    }


    @Test
    void exchange() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/exchange");

        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", equalTo(123)))
                .andExpect(jsonPath("$.name", equalTo("Judy")));
    }
}