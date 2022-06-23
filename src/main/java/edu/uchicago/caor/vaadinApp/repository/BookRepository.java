package edu.uchicago.caor.vaadinApp.repository;


import edu.uchicago.caor.vaadinApp.models.VolumesResponse;
import edu.uchicago.caor.vaadinApp.service.AsyncRestCallback;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class BookRepository {



    //READ paged
    public void getBooks(AsyncRestCallback<VolumesResponse> callback, String search, int maxResults,
                         int startIndex) {


        String raw = "https://www.googleapis.com/books/v1/volumes?q=%s&maxResults=%d&startIndex=%d";
        String formatted = String.format(raw, search, maxResults, startIndex);
        WebClient.RequestHeadersSpec<?> spec = WebClient.create().get().uri(formatted);

        spec.retrieve().toEntity(VolumesResponse.class).subscribe(result -> {

            final VolumesResponse volumesResponse = result.getBody();

            if (null == volumesResponse.getItems()) return;

            callback.operationFinished(volumesResponse);

        });

    }
}
