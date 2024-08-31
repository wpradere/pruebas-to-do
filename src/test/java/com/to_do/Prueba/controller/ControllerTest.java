package com.to_do.Prueba.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.to_do.Prueba.dtos.request.RequestTask;
import com.to_do.Prueba.dtos.response.ResponseTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@WebAppConfiguration
class ControllerTest {



    private final static String URL_CAEDCREATE="/todo/usersTask";

    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setUp() {

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    void createTask () throws Exception {

        RequestTask request = buildRequest4();


        MvcResult mockMvcResulta = mockMvc.perform(MockMvcRequestBuilders.get(URL_CAEDCREATE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE).content(mapJson(request)))
                .andReturn();
        assertEquals(400,mockMvcResulta.getResponse().getStatus());
    }

    private String mapJson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    private RequestTask buildRequest4(){
        RequestTask request =
                RequestTask.builder()
                        .name_list("cita odontologica")
                        .state("No resuelto")
                        .build();
        return request;
    }



}