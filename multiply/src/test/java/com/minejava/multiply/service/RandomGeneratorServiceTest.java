package com.minejava.multiply.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class RandomGeneratorServiceTest {

    @Autowired
    private RandomGeneratorService randomGeneratorService;

    @Test
    public void generateThatRandomFactorIsBetweenLimits() throws Exception {
        List<Integer> randomFractors = IntStream.range(0, 1000)
                .map(i -> randomGeneratorService.generateRandomFactor())
                .boxed().collect(Collectors.toList());
        
        // Assert that random numbers is between 11 and 1000
        assertThat(randomFractors).containsOnlyElementsOf
        (IntStream.range(11, 100)
                .boxed().collect(Collectors.toList()));
    }
    
}
