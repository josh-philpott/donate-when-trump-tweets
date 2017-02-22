package com.joshphilpott.controllers;

import com.joshphilpott.models.User;
import com.joshphilpott.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by pterodactyl on 2/21/17.
 */
@Controller
@RequestMapping("/home")
@Slf4j
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String getHome(Principal principal, Model model){
        User user = userRepository.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "/home";
    }
}
