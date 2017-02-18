package com.joshphilpott.controllers;

import com.joshphilpott.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

/**
 * Created by pterodactyl on 2/18/17.
 */
@Slf4j
@Controller
@RequestMapping(path="/signup")
public class RegistrationController extends WebMvcConfigurerAdapter{
    @PostMapping
    public String validateAndRegister(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "signup";
        }

        log.info("Received signup request: {}", user);
        return "redirect:/login";
    }

    @GetMapping
    public String displaySignup(User user){
        return "signup";
    }
}
