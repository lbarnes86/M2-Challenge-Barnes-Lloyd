package com.company.M2ChallengeBarnesLloyd.controller;

import com.company.M2ChallengeBarnesLloyd.models.Month;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@WebMvcTest(MonthController.class)

public class MonthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {}

    @Test
    public void getMonthByMonthNumber() throws Exception {
//        Arrange
        Month month = new Month(2, "February");
        String outputJson = mapper.writeValueAsString(month);

//        Act
        mockMvc.perform(get("/month/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getRandomMonth() throws Exception {

        mockMvc.perform(get("/randomMonth"))
                .andDo(print())
                .andExpect(status().isOk());

    }
    // Copied code from RecordStoreControllerTests assignment.
    @Test
    public void  shouldReturnError422Status() throws Exception{
        mockMvc.perform(get("/month/13").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
}