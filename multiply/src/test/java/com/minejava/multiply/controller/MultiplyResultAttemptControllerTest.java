package com.minejava.multiply.controller;

import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.minejava.multiply.domain.Multiply;
import com.minejava.multiply.domain.MultiplyResultAttempt;
import com.minejava.multiply.domain.ResultResponse;
import com.minejava.multiply.domain.User;
import com.minejava.multiply.service.MultiplyService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@WebMvcTest(MultiplyResultAttemptController.class)
public class MultiplyResultAttemptControllerTest {

    @MockBean
    private MultiplyService multiplyService;

    @Autowired
    MockMvc mockMvc;

    // Objects will be initialized by initFIELDS below
    private JacksonTester<MultiplyResultAttempt> jsonResult;
    private JacksonTester<ResultResponse> jsonResponse;

    @BeforeEach
    public void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    public void postResultReturnCorrect() throws Exception {
        generictParameterTest(true);
    }

    @Test
    public void postResultReturnNotReturnCorrect() throws Exception{
        generictParameterTest(false);
        
    }

    private void generictParameterTest(final boolean correct) throws Exception {
        // Given and not testing service
        given(multiplyService.checkAttempt(any(MultiplyResultAttempt.class)))
        .willReturn(correct);
         User user = new User("John");
         Multiply multiply = new Multiply(20, 50);
         MultiplyResultAttempt multiplyResultAttempt = new MultiplyResultAttempt(user, multiply, 1000);
        
         // when
         MockHttpServletResponse response = mockMvc.perform(post("/results")
              .contentType(MediaType.APPLICATION_JSON)
              .content(jsonResult.write(multiplyResultAttempt)
              .getJson()))
            .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
            jsonResponse.write(
                new ResultResponse(correct)).getJson());
    }
}
