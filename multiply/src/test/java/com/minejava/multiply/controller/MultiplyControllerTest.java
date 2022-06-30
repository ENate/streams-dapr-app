package com.minejava.multiply.controller;

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
import com.minejava.multiply.service.MultiplyService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import static org.assertj.core.api.Assertions.assertThat;

@WebMvcTest(MultiplyController.class)
public class MultiplyControllerTest {
    @MockBean
    private MultiplyService multiplyService;

    @Autowired
    private MockMvc mockMvc;

    // This object will be auto initialized via the init fields below
    private JacksonTester<Multiply> json;

    @BeforeEach
    public void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    public void getRandomMultiplyTest() throws Exception{
        //given
        given(multiplyService.createRandomMultiply().willReturn(new Multiply(70, 20)));
        // when
        MockHttpServletResponse response = mockMvc.perform(get("/muliplications/random")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        
        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString())
                           .isEqualTo(json.write(new Multiply(30, 40)).getJson());

    }
}
