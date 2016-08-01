package com.dataart.retman.controller;

import com.dataart.retman.exception.DublicateSpittleMessageException;
import com.dataart.retman.exception.SpittleNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.util.NestedServletException;

@ControllerAdvice
public class AdviceController {

    @ExceptionHandler({NestedServletException.class, SpittleNotFoundException.class})
    public String handle404(Exception ex) {
        return "redirect:/404";
    }

    @ExceptionHandler(DublicateSpittleMessageException.class)
    public String handleDuplicate(Exception ex) {
//        model.addAttribute(((DublicateSpittleMessageException) ex).getSpittle());
//        ((RedirectAttributes) model).addAttribute(new Spittle("test message", new Date()));
        return "redirect:/duplicate";
    }

}
