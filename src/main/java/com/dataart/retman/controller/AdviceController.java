package com.dataart.retman.controller;

//@ControllerAdvice
public class AdviceController {

//    @ExceptionHandler(NoHandlerFoundException.class)
    public String handle404(Exception ex) {
        return "redirect:/404";
    }

//    @ExceptionHandler(Exception.class)
    public String handle500(Exception ex) {
        return "redirect:/500";
    }

}
