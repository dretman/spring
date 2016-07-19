package com.dataart.retman.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Arrays;
import java.util.List;

@Controller
public class TestController {

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public void throwNoHandlerFoundException() throws NoHandlerFoundException {
        throw new NoHandlerFoundException("", "", new HttpHeaders());
    }

    @RequestMapping(value = {"/404"}, method = RequestMethod.GET)
    public String NotFoudPage(Model model) {
        model.addAttribute("pic", getRandom404Pic());
        return "404";
    }

    @RequestMapping(value = {"/500"}, method = RequestMethod.GET)
    public String ServerError() {
        return "500";
    }

    private int getRandom404Pic() {
        List<Integer> list = Arrays.asList(4040, 4041, 4042, 4043);
        return list.get((int) (Math.random() * 4));
    }
}
