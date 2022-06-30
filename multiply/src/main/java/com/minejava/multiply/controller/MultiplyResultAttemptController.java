package com.minejava.multiply.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.minejava.multiply.domain.MultiplyResultAttempt;
import com.minejava.multiply.domain.ResultResponse;
import com.minejava.multiply.service.MultiplyService;

@RestController
@RequestMapping("/results")
public class MultiplyResultAttemptController {

    private final MultiplyService multiplyService;

//@Autowired
    MultiplyResultAttemptController(final MultiplyService multiplyService) {
        this.multiplyService = multiplyService;
    }

    // Implement post method
    @PostMapping
    ResponseEntity<ResultResponse> postResult(@RequestBody
    MultiplyResultAttempt multiplyResultAttempt) {
        return ResponseEntity.ok(
            new ResultResponse(multiplyService.checkAttempt(multiplyResultAttempt)));
    }
    
}
