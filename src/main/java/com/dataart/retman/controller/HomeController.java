package com.dataart.retman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/", "/homePage"})
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/loginForm", method = RequestMethod.GET)
    public String login(Model model) {
//        model.addAttribute("login", new LoginForm());
        return "login";
    }


    @RequestMapping(value = "duplicate", method = RequestMethod.GET)
    public String duplicate(Model model) {
        model.addAttribute("message", "Duplicate value:");
        return "duplicate";
    }

//    @RequestMapping(value="/logoutUrl", method = RequestMethod.GET)
//    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null){
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "redirect:/homePage";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
//    }

}
