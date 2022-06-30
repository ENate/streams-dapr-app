package com.minejava.multiply.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Identifies the attempte from a {@link User} to solve a
 * {@link Multiply}
 */

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public final class MultiplyResultAttempt {

    private final User user;
    private final Multiply multiply;
    private final int resultAttempt;

    // Emplty constructor for desrialization
    MultiplyResultAttempt() {
        user = null;
        multiply = null;
        resultAttempt = -1;
    }
}
