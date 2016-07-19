package com.dataart.retman.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class AdviceController {

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handle404(Exception ex) {
        return "redirect:/404";
    }

    @ExceptionHandler(Exception.class)
    public String handle500(Exception ex) {
        return "redirect:/500";
    }

}
