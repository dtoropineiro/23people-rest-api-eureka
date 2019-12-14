package com.dario.project23people.controller;

import com.netflix.discovery.converters.Auto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.ws.rs.core.MediaType;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CourseController.class)
public class TestCourseController {

    @Autowired
    private MockMvc mvc;

    public TestCourseController(){

    }

    @Test
    public void getAllCourses() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .get("/courses")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.courses").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.courses[*].name").isNotEmpty());
    }

}
