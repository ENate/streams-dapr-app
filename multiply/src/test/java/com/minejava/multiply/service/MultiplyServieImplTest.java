package com.minejava.multiply.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.minejava.multiply.domain.Multiply;


public class MultiplyServieImplTest {
    private MultiplyServiceImpl multiplyServiceImpl;

    @Mock 
    private RandomGeneratorService randomGeneratorService;

    @BeforeEach
    public void setUp() {
        // Call init mocks to process annotations
        MockitoAnnotations.initMocks(this);
        multiplyServiceImpl = new MultiplyServieImplTest(randomGeneratorService);
    }

    @Test
    public void createRandomMultiplyTest() {
        // Mock generator will return 30 and then 50
        given(randomGeneratorService.generateRandomFactor()).
        willReturn(50, 30);

        // when
        Multiply multiply = new multiplyServiceImpl.createRandomMultiply();

        // assert
        assertThat(Multiply.getFactorA()).isEqualTo(50);
        assertThat(Multiply.getFactorB()).isEqualTo(50);
        assertThat(Multiply.getResult()).isEqualTo(1500);

        
    }
}
