package com.dataart.retman.controller;

import com.dataart.retman.domain.Spittle;
import com.dataart.retman.repository.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/spittles")
public class SpittleController {
    private static final String MAX_LONG_AS_STRING = Long.toString(Long.MAX_VALUE);
    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(
            @RequestParam(value = "max", defaultValue = "9223372036854775807") long max,
            @RequestParam(value = "count", defaultValue = "20") int count,
            Model model
    ) {
        List<Spittle> spittleList = spittleRepository.findSpittles(max, count);
        model.addAttribute("spittleList", spittleList);
        return "spittles";
    }

    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public ModelAndView spittle(
            @PathVariable(value = "spittleId") long spittleId
    ) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("spittle");
        modelAndView.addObject("spittle", spittleRepository.findOne(spittleId));
        return modelAndView;
    }

}
