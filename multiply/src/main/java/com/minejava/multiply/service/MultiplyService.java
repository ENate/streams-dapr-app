package com.minejava.multiply.service;

import com.minejava.multiply.domain.Multiply;
import com.minejava.multiply.domain.MultiplyResultAttempt;

public interface MultiplyService {
    /**
     * Generates a ramdom {@link Multiply} object
     * 
     * @return a multiplication of randomly generated numbers
     */
    Multiply createRandoMultiply();

    /**
     * @return true if the attempt matches the result of the multiplication,
     * or false, otherwise
     */

     boolean checkAttempt(final MultiplyResultAttempt resultAttempt);

     
}
