package com.dataart.retman.controller;

import com.dataart.retman.domain.Spitter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class RestControllerClass {

    @RequestMapping(value = "/cars", method = RequestMethod.GET,produces = "application/json")
    public
    @ResponseBody
    List<Spitter> car() {
        Spitter denis = new Spitter("Denis", "Retman", "disa", "12345");
        Spitter david = new Spitter("David", "Shwimmer", "davii", "12345");
        return Arrays.asList(denis, david);
    }

}
