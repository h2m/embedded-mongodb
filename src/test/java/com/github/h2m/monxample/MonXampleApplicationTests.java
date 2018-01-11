package com.github.h2m.monxample;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class MonXampleApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void getPersons() throws Exception {
        mockMvc.perform(get("/persons")).
                andExpect(status().isOk());
    }


    @Test
    public void addPerson() throws Exception {
        mockMvc.perform(post("/persons/testName")).
                andExpect(status().isOk());

        mockMvc.perform(get("/persons/testName")).
                andExpect(status().isOk());
    }

    @Test
    public void getPerson() throws Exception {
        mockMvc.perform(get("/persons/blablupp")).andExpect(status().isNotFound());
    }
}
