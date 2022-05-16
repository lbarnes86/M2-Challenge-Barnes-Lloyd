package com.company.M2ChallengeBarnesLloyd.controller;

import com.company.M2ChallengeBarnesLloyd.models.MathSolution;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

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
    public void shouldAddInteger() throws Exception {

        MathSolution sum = new MathSolution();
        sum.setOperand1(600);
        sum.setOperand2(250);
        sum.setOperation("add");

        String inputJson = mapper.writeValueAsString(sum);

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
    public void shouldRespondWith422ErrorIfAddWithNull() throws Exception {
        MathSolution sum = new MathSolution();
        sum.setOperand1(7);
        sum.setOperand2(null);
        sum.setOperation("add");

        String inputJson = mapper.writeValueAsString(sum);

        mockMvc.perform(post("/add")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
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
    public void shouldRespondWith422ErrorIfSubtractWithNull() throws Exception {
        MathSolution difference = new MathSolution();
        difference.setOperand1(null);
        difference.setOperand2(6);
        difference.setOperation("subtract");

        String inputJson = mapper.writeValueAsString(difference);

        mockMvc.perform(post("/subtract")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
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
    public void shouldRespondWith422ErrorIfMultiplyWithNull() throws Exception {
        MathSolution product = new MathSolution();
        product.setOperand1(9);
        product.setOperand2(null);
        product.setOperation("multiply");

        String inputJson = mapper.writeValueAsString(product);

        mockMvc.perform(post("/multiply")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
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
    public void shouldRespondWith422ErrorIfOperand2IsZero() throws Exception {
        MathSolution quotient = new MathSolution();
        quotient.setOperand1(4);
        quotient.setOperand2(0);
        quotient.setOperation("divide");

        String inputJson = mapper.writeValueAsString(quotient);

        mockMvc.perform(post("/divide")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldRespondWith422ErrorIfDivideWithNull() throws Exception {
        MathSolution quotient = new MathSolution();
        quotient.setOperand1(9);
        quotient.setOperand2(null);
        quotient.setOperation("divide");

        String inputJson = mapper.writeValueAsString(quotient);

        mockMvc.perform(post("/divide")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }


}