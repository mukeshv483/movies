package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * @author Mukesh Verma
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public  ProblemDetail handleException(){
        ProblemDetail detail=ProblemDetail.forStatus(HttpStatus.SERVICE_UNAVAILABLE);
        detail.setDetail("unknown error");
        return detail;

    }
}
