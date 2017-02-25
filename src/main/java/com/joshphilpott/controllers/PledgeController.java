package com.joshphilpott.controllers;

import com.joshphilpott.models.Pledge;
import com.joshphilpott.models.User;
import com.joshphilpott.repository.PledgeRepository;
import com.joshphilpott.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by pterodactyl on 2/21/17.
 */
@Controller
@RequestMapping("/pledge")
@Slf4j
public class PledgeController {

    @Autowired
    PledgeRepository pledgeRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping(path = "/create")
    public String getCreatePledge(){
        return "pledge/create";
    }

    @PostMapping(path = "/create")
    public String createPledge(Pledge pledge, Principal principal){
        log.info("Pledge: {}", pledge.toString());
        Pledge savedPledge = pledgeRepository.save(pledge);
        User updatedUser = userRepository.findByUsername(principal.getName());
        updatedUser.setPledge(savedPledge);
        userRepository.save(updatedUser);

        return "forward:pledge/view";
    }

    @GetMapping(path = "/view")
    public String getPledges(Principal principal, Model model){
       //Pledge[] pledge = pledgeRepository.findAllByUsername(principal.getName());
        Pledge pledge = userRepository.findByUsername(principal.getName()).getPledge();
        model.addAttribute("pledge", pledge);
        return "pledge/view";
    }

}
