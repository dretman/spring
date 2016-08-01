package com.dataart.retman.controller;

import com.dataart.retman.error.Error;
import com.dataart.retman.exception.DublicateSpittleMessageException;
import com.dataart.retman.exception.SpittleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.NestedServletException;

@ControllerAdvice
public class AdviceController {

    @ExceptionHandler({NestedServletException.class})
    public String handle404(Exception ex) {
        return "redirect:/404";
    }

    @ExceptionHandler(DublicateSpittleMessageException.class)
    public String handleDuplicate(Exception ex) {
//        model.addAttribute(((DublicateSpittleMessageException) ex).getSpittle());
//        ((RedirectAttributes) model).addAttribute(new Spittle("test message", new Date()));
        return "redirect:/duplicate";
    }

    @ExceptionHandler(SpittleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody Error spittleNotFoundHandler(SpittleNotFoundException e){
        return new Error(4, "Spittle with id [" + e.getSpittleId() + "] really © not found");
    }

}
