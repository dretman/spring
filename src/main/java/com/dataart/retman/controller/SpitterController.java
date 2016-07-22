package com.dataart.retman.controller;

import com.dataart.retman.domain.Spitter;
import com.dataart.retman.repository.SpitterRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping(value = "/spitter")
public class SpitterController {
    private static final Log LOG = LogFactory.getLog(SpitterController.class);
    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistartionForm(Model model) {
        Spitter spitter = new Spitter("first name", "last name", "username", "password");
        spitter = new Spitter();
        model.addAttribute("spitter", spitter);
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveSpitter(@RequestPart("profilePicture") MultipartFile profilePicture, @Valid Spitter spitter, Errors errors) {
        spitterRepository.save(spitter);

        if (errors.hasErrors())
            return "registerForm";

        File file = new File(profilePicture.getOriginalFilename());
        try {
            profilePicture.transferTo(file);
        } catch (IOException e) {
            System.err.println(e);
        }

        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        Spitter spitter = spitterRepository.findByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }

    public static void main(String[] args) {
        LOG.info("picture array size: ");
    }

}
