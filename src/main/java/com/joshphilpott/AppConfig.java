package com.joshphilpott;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;

import javax.inject.Inject;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Created by pterodactyl on 2/17/17.
 */
@Slf4j
@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
    @Value("${spring.social.twitter.appId}")
    private String key;
    @Value("${spring.social.twitter.appSecret}")
    private String secret;

    @Inject
    private Environment environment;

    @Bean
    public Twitter twitter(){
        return new TwitterTemplate(key, secret);
    }

}
