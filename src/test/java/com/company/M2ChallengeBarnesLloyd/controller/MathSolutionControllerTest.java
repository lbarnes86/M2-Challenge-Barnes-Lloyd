package com.company.M2ChallengeBarnesLloyd.controller;

import com.company.M2ChallengeBarnesLloyd.models.MathSolution;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@RunWith(SpringRunner.class)
@WebMvcTest(MathSolutionController.class)
public class MathSolutionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {

    }


    @Test
    public void shouldAddInteger() throws Exception{

        MathSolution problem = new MathSolution();
        problem.setOperand1(600);
        problem.setOperand2(250);
        problem.setOperation("add");

        String inputJson = mapper.writeValueAsString(problem);

        MathSolution output = new MathSolution();
        output.setOperand1(600);
        output.setOperand2(250);
        output.setOperation("add");
        output.setAnswer(850);
        String outputJson = mapper.writeValueAsString(output);

        mockMvc.perform(post("/add")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)

                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }


    @Test
    public void shouldSubtractInteger() throws Exception {
        MathSolution problem = new MathSolution();
        problem.setOperand1(810);
        problem.setOperand2(760);
        problem.setOperation("subtract");

        String inputJson = mapper.writeValueAsString(problem);

        MathSolution output = new MathSolution();
        output.setOperand1(810);
        output.setOperand2(760);
        output.setOperation("subtract");
        output.setAnswer(50);
        String outputJson = mapper.writeValueAsString(output);

        mockMvc.perform(post("/subtract")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)

                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldMultiplyInteger() throws Exception {
        MathSolution problem = new MathSolution();
        problem.setOperand1(50);
        problem.setOperand2(200);
        problem.setOperation("multiply");

        String inputJson = mapper.writeValueAsString(problem);

        MathSolution output = new MathSolution();
        output.setOperand1(50);
        output.setOperand2(200);
        output.setOperation("multiply");
        output.setAnswer(10000);
        String outputJson = mapper.writeValueAsString(output);

        mockMvc.perform(post("/multiply")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)

                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }


    @Test
    public void shouldDivideInteger() throws Exception {
        MathSolution problem = new MathSolution();
        problem.setOperand1(500);
        problem.setOperand2(250);
        problem.setOperation("divide");

        String inputJson = mapper.writeValueAsString(problem);

        MathSolution output = new MathSolution();
        output.setOperand1(500);
        output.setOperand2(250);
        output.setOperation("divide");
        output.setAnswer(2);
        String outputJson = mapper.writeValueAsString(output);

        mockMvc.perform(post("/divide")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)

                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldReturn422StatusMultiplicationInvalid() throws  Exception {

        Map<String, String> problem = new HashMap<>();
        problem.put("operand1", "2");
        problem.put("operand2", "not a number");

        String inputJson = mapper.writeValueAsString(problem);

        mockMvc.perform(
                        post("/multiply")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturn422ErrorForInvalidAddRequest() throws Exception {

        Map<String, String> problem = new HashMap<>();
        problem.put("operand1", "2");
        problem.put("operand2", "not a number");

        String inputJson = mapper.writeValueAsString(problem);

        mockMvc.perform(
                        post("/add")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
}
