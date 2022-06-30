package com.minejava.multiply.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This is to multiply: (a * b)
 */

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public final class Multiply {
    
    // Both factors
    private final int factorA;
    private final int factorB;

    // Emplty constructor for json serialization

    Multiply() {
        this(0, 0);
    }
}
