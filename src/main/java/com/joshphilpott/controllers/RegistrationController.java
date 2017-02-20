package com.joshphilpott.controllers;

import com.joshphilpott.models.User;
import com.joshphilpott.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Autowired
    UserService userService;

    @PostMapping
    public String validateAndRegister(@Valid User user, Model model, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "/signup";
        }

        if(userService.emailExists(user.getEmail())){
            model.addAttribute("emailExists", true);
            return "/signup";
        }

        if(userService.usernameExists(user.getUsername())){
            model.addAttribute("usernameExists", true);
            return "/signup";
        }

        log.info("Received valid signup request. Registering user: {}", user);
        User registeredUser = userService.save(user);
        log.info("Successfully registered: {}", registeredUser);

        return "redirect:/login";
    }


    @GetMapping
    public String displaySignup(User user, Model model){
        return "/signup";
    }
}
