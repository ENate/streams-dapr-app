package com.minejava.multiply.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minejava.multiply.domain.Multiply;
import com.minejava.multiply.service.MultiplyService;

@RestController
@RequestMapping("/multiplications")
public class MultiplyController {
    
    private final MultiplyService multiplyService;

    //@Autowired
    public MultiplyController(final MultiplyService multiplyService) {
        this.multiplyService = multiplyService;
    }

    // Implement the rest end point
    @GetMapping("/random")
    Multiply getRandomMultiply() {
        return multiplyService.createRandomMultiply();
    }
}
