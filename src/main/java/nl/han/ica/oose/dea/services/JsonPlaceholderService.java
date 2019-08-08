package nl.han.ica.oose.dea.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.Consumer;

public class JsonPlaceholderService {

    private HttpClient client;

    public JsonPlaceholderService() {
        client = HttpClient.newHttpClient();
    }

    public void getTodos() {
        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/todos"))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenAccept(
                response -> {
                    System.out.println(response.body());
                });
    }

    public void getTodosWithCallback(Consumer<String> action) {
        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/todos"))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenAccept(
                response -> {
                    var body = response.body();
                    action.accept(body);
                });
    }
}
