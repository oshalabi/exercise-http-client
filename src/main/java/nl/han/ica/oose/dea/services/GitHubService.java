package nl.han.ica.oose.dea.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GitHubService {

    public String getIndexHtml(){

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("hrrp://github.com/"))
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> {System.out.println(response.statusCode());
                return response; })
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println);
        return "re";


    }

    public String getReadme() {
        return "";
    }
}
