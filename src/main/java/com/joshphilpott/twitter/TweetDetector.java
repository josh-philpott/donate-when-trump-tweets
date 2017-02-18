package com.joshphilpott.twitter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * Fires an event every time @RealDonaldTrump tweets
 *
 * Created by pterodactyl on 2/12/17.
 */
@Slf4j
@Component
public class TweetDetector {

    @Autowired
    private Twitter twitter;

    public TweetDetector(Twitter twitter){
        this.twitter = twitter;
        //getTrumpTweets();
    }


    public void getTrumpTweets(){
        List<Tweet> tweets = twitter.timelineOperations().getUserTimeline("realDonaldTrump");
        for(Tweet tweet: tweets){
            log.info(tweet.getText());
        }
    }
}
