package edu.uchicago.caor.vaadinApp.repository;


import edu.uchicago.caor.vaadinApp.models.TweetsResponse;
import edu.uchicago.caor.vaadinApp.service.AsyncRestCallback;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URISyntaxException;
import java.util.ArrayList;

@Repository
public class TweetRepository {
    private static String BEARER_TOKEN = "AAAAAAAAAAAAAAAAAAAAAIR7eAEAAAAAGtUbFRGPU9%2FeOSK%2FNUPlITxs7HQ%3DAsOcMx75iTWuQKtFciAqAHQOefeE4Irecb02MyiBmy0P9hdCgd";

    //READ page
    public static void getTweets(AsyncRestCallback<TweetsResponse> callback, String searchString, int maxResults,
                                 String nextToken) {
        // build http query string
        URIBuilder uriBuilder = null;
        try {
            uriBuilder = new URIBuilder("https://api.twitter.com/2/tweets/search/recent");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ArrayList<NameValuePair> queryParameters = new ArrayList<>();
        queryParameters.add(new BasicNameValuePair("query", searchString));
        queryParameters.add(new BasicNameValuePair("expansions", "author_id"));
        queryParameters.add(new BasicNameValuePair("max_results", String.valueOf(maxResults)));
//        queryParameters.add(new BasicNameValuePair("tweet.fields", "author_id"));
        queryParameters.add(new BasicNameValuePair("user.fields", "profile_image_url,username"));

        if (nextToken != null) {
            queryParameters.add(new BasicNameValuePair("next_token", nextToken));
        }
        uriBuilder.addParameters(queryParameters);

        // request the quest with authorization info
        WebClient.RequestHeadersSpec<?> spec = null;
        try {
            spec = WebClient.create().get()
                    .uri(uriBuilder.build())
                    .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                    .headers(headers -> headers.setBearerAuth(BEARER_TOKEN));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        // retrieve the tweet from the API
        spec.retrieve().toEntity(TweetsResponse.class).subscribe(result -> {
            // cast response to TweetResponse
            final TweetsResponse tweetsResponse = result.getBody();
            if (null == tweetsResponse.getData()) return;
            callback.operationFinished(tweetsResponse);
        });
    }

}
