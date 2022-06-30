package com.minejava.multiply.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.minejava.multiply.domain.Multiply;
import com.minejava.multiply.domain.MultiplyResultAttempt;
import com.minejava.multiply.domain.User;

import static org.assertj.core.api.Assertions.assertThat;


public class MultiplyServiceImplTest {

    @Autowired
    private MultiplyServiceImpl multiplyServiceImpl;

    @Mock 
    private RandomGeneratorService randomGeneratorService;

    @Test
    public void checkCorrectAttemptTest() {
        // Mock generator will return 30 and then 50
        //
        Multiply multiply = new Multiply(34, 11);
        User user = new User("Doherty Jack Ashley");
        MultiplyResultAttempt attempt = new MultiplyResultAttempt(user, multiply, 374);

        // when
        boolean attemptResult = multiplyServiceImpl.checkAttempt(attempt);
        // assert
        assertThat(attemptResult).isTrue();
        //(multiply.getFactorB()).isEqualTo(50);
        //assertThat(multiply.getResult()).isEqualTo(1500);
    }

    @Test
    public void checkWrongAttemptResult() {
        // given
        Multiply multiply = new Multiply(34, 11);
        User user = new User("Doherty Jack Ashley");
        MultiplyResultAttempt attempt = new MultiplyResultAttempt(user, multiply, 3011);
        // when
        boolean attemptResult = multiplyServiceImpl.checkAttempt(attempt);

        // assert
        assertThat(attemptResult).isFalse();
    }
}
