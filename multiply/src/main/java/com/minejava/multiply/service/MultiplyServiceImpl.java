package com.minejava.multiply.service;

import com.minejava.multiply.domain.Multiply;
import com.minejava.multiply.domain.MultiplyResultAttempt;

public class MultiplyServiceImpl implements MultiplyService{

    @Override
    public Multiply createRandomMultiply() {
        // DO Auto-generated method stub
        return null;
    }

    @Override
    public boolean checkAttempt(final MultiplyResultAttempt resultAttempt) {
        // TO DO Auto-generated method stub
        return resultAttempt.getResultAttempt() ==
            resultAttempt.getMultiply().getFactorA() * 
            resultAttempt.getMultiply().getFactorB();
    }
    
}
