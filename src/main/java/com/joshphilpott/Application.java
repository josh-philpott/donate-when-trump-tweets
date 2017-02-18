package com.joshphilpott;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by pterodactyl on 2/17/17.
 */
@RequiredArgsConstructor
@Slf4j
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        log.info("Starting Donate-When-Trump-Tweets");
        SpringApplication.run(Application.class, args);
    }
}
