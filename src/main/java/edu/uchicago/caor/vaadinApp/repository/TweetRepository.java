package edu.uchicago.caor.vaadinApp.repository;


import edu.uchicago.caor.vaadinApp.models.TweetsResponse;
import edu.uchicago.caor.vaadinApp.service.AsyncRestCallback;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

@Repository
public class TweetRepository {
    private static String BEARER_TOKEN = "AAAAAAAAAAAAAAAAAAAAAIR7eAEAAAAAGtUbFRGPU9%2FeOSK%2FNUPlITxs7HQ%3DAsOcMx75iTWuQKtFciAqAHQOefeE4Irecb02MyiBmy0P9hdCgd";

    //READ page
    public static void getTweets(AsyncRestCallback<TweetsResponse> callback, String searchString, int maxResults,
                                 int startIndex) throws IOException, URISyntaxException {
        // init Http client to send http request
        HttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setCookieSpec(CookieSpecs.STANDARD).build())
                .build();

        // build http query string
        URIBuilder uriBuilder = new URIBuilder("https://api.twitter.com/2/tweets/search/recent");
        ArrayList<NameValuePair> queryParameters = new ArrayList<>();
        queryParameters.add(new BasicNameValuePair("query", searchString));
        queryParameters.add(new BasicNameValuePair("max_results", String.valueOf(maxResults)));
        queryParameters.add(new BasicNameValuePair("tweet.fields", "author_id"));
        uriBuilder.addParameters(queryParameters);
//        System.out.println(uriBuilder.build());

        // request the quest with authorization info
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Authorization", String.format("Bearer %s", BEARER_TOKEN));
        httpGet.setHeader("Content-Type", "application/json");
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();

        // cast response to TweetResponse
        if (null != entity) {
            final TweetsResponse tweetsResponse = (TweetsResponse) entity;
            if (null == tweetsResponse.getData()) return;
            System.out.println(tweetsResponse);
            callback.operationFinished(tweetsResponse);
        }
    }

    //    public void getTweets(AsyncRestCallback<VolumesResponse> callback, String search, int maxResults,
//                          int startIndex) {
//
//        String raw = "https://www.googleapis.com/books/v1/volumes?q=%s&maxResults=%d&startIndex=%d";
//        String formatted = String.format(raw, search, maxResults, startIndex);
//        WebClient.RequestHeadersSpec<?> spec = WebClient.create().get().uri(formatted);
//
//        spec.retrieve().toEntity(VolumesResponse.class).subscribe(result -> {
//
//            final VolumesResponse volumesResponse = result.getBody();
//
//            if (null == volumesResponse.getItems()) return;
//
//            callback.operationFinished(volumesResponse);
//
//        });
//
//    }
}
