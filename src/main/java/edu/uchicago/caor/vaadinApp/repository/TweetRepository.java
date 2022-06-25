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

import javax.print.attribute.standard.MediaTray;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

@Repository
public class TweetRepository {
    private static String BEARER_TOKEN = "AAAAAAAAAAAAAAAAAAAAAIR7eAEAAAAAGtUbFRGPU9%2FeOSK%2FNUPlITxs7HQ%3DAsOcMx75iTWuQKtFciAqAHQOefeE4Irecb02MyiBmy0P9hdCgd";

    //READ page
    public static void getTweets(AsyncRestCallback<TweetsResponse> callback, String searchString, int maxResults, String nextToken) throws IOException, URISyntaxException {
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
        if (nextToken != null) {
            queryParameters.add(new BasicNameValuePair("next_token", nextToken));
        }
        uriBuilder.addParameters(queryParameters);


//        HttpGet httpGet = new HttpGet(uriBuilder.build());
//        httpGet.setHeader("Authorization", String.format("Bearer %s", BEARER_TOKEN));
//        httpGet.setHeader("Content-Type", "application/json");
//        HttpResponse response = httpClient.execute(httpGet);
//        HttpEntity entity = response.getEntity();
//        System.out.println("----------------------------------------------------------");
//        System.out.println(EntityUtils.toString(entity, "UTF-8"));
//        System.out.println("----------------------------------------------------------!!!!!!!!!!");


//        if (entity != null) {
//            final TweetsResponse tweetsResponse = (TweetsResponse) entity;
//            if (null == tweetsResponse.getData()) return;
////            callback.operationFinished(tweetsResponse);
//        }

        // request the quest with authorization info
        WebClient.RequestHeadersSpec<?> spec = WebClient.create().get()
                .uri(uriBuilder.build())
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .headers(headers -> headers.setBearerAuth(BEARER_TOKEN));

        spec.retrieve().toEntity(TweetsResponse.class).subscribe(result -> {
            // cast response to TweetResponse
            final TweetsResponse volumesResponse = result.getBody();
            if (null == volumesResponse.getData()) return;
            callback.operationFinished(volumesResponse);
        });
    }
}
