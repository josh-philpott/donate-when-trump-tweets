package com.joshphilpott.controllers;

/**
 * Created by pterodactyl on 2/21/17.
 */

import com.joshphilpott.models.CreditCard;
import com.joshphilpott.models.User;
import com.joshphilpott.repository.CreditCardRepository;
import com.joshphilpott.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Adds credit card data for user.
 */
@RestController
@RequestMapping("/payments")
@Slf4j
public class PaymentController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CreditCardRepository creditCardRepository;

    @PostMapping
    public void addPaymentMethod(@Valid CreditCard creditCard, Principal principal){
        log.info("Received POST w/ {}, {}", creditCard, principal);

        CreditCard savedCreditCard = creditCardRepository.save(creditCard);

        String username = principal.getName();
        User user = userRepository.findByUsername(username);
        user.setCreditCard(savedCreditCard);
        userRepository.save(user);
    }
}

