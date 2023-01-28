package com.moura.apigateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {
    @GetMapping("/retroServiceFallBack")
    public ResponseEntity<String> retroServiceFallBackMethod(){
        String message = "Retro Service is taking longer than expected to respond." +
                " Please try again later";
        return new ResponseEntity<>(message, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @GetMapping("/rentServiceFallBack")
    public ResponseEntity<String> rentServiceFallBackMethod(){
        String message = "Rent Service is taking longer than expected to respond." +
                " Please try again later";
        return new ResponseEntity<>(message, HttpStatus.SERVICE_UNAVAILABLE);
    }
}
