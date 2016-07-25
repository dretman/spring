package com.dataart.retman.controller;

import com.dataart.retman.domain.Spittle;
import com.dataart.retman.exception.DublicateSpittleMessageException;
import com.dataart.retman.exception.SpittleNotFoundException;
import com.dataart.retman.repository.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

        Spittle spittle = spittleRepository.findOne(spittleId);
        if (spittle == null) {
            throw new SpittleNotFoundException();
        }

        modelAndView.addObject("spittle", spittle);
        return modelAndView;
    }

    @RequestMapping(value = "/spittle", method = RequestMethod.GET)
    public String showSpittleForm(Model model) {
        model.addAttribute("spittle", new Spittle());
        return "addSpittle";
    }

    @RequestMapping(value = "/spittle", method = RequestMethod.POST)
    public String addSpittle(Spittle spittle, RedirectAttributes model) throws DublicateSpittleMessageException {
        try {
            spittleRepository.save(spittle);
        } catch (DublicateSpittleMessageException e) {
            model.addFlashAttribute(spittle);
            return "redirect:/duplicate";
        }

        return "addSpittle";
    }

}
