package nl.han.ica.oose.dea.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GitHubService {

    private HttpClient client;

    public GitHubService() {
        client = HttpClient.newHttpClient();
    }

    public String getIndexHtml() {
        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://github.com"))
                .build();

        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException | IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return (response.body());
    }

    public String getReadme() {
        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://raw.githubusercontent.com/HANICA-DEA/exercise-http-client/master/README.md"))
                .build();
        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException | IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return (response.body());
    }
}
