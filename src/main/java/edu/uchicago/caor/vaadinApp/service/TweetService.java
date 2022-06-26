package edu.uchicago.caor.vaadinApp.service;



import edu.uchicago.caor.vaadinApp.models.TweetsResponse;
import edu.uchicago.caor.vaadinApp.repository.TweetRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;

@Service
public class TweetService {
    public static final int MAX_RESULTS = 20;
    private TweetRepository tweetRepository;

    public TweetService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

   //READ paged
    public void getTweets(AsyncRestCallback<TweetsResponse> callback, String search, int maxResults,
                          String next_token) {
        // call get Tweets method to get API response
        tweetRepository.getTweets(callback, search, maxResults, next_token);
    }
}
