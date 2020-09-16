package nl.han.ica.oose.dea.services;

import nl.han.ica.oose.dea.services.dtos.TodoDto;
import nl.han.ica.oose.dea.services.mappers.TodoMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.Consumer;

public class JsonPlaceholderService {

    private TodoMapper todoMapper;

    public JsonPlaceholderService() {
        todoMapper = new TodoMapper();
    }

    public void getTodos() {

        var requset = HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/todos")).build();

            httpClient.sendAsync(requset, HttpResponse.BodyHandlers.ofString()).thenAccept(response -> {
                        System.out.println(response.body());
                    }
            );
    }

    public void getTodosWithCallback(Consumer<String> callback) {
        var httpCleint = HttpClient.newHttpClient();
        var requset = HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/todos")).build();
        httpCleint.sendAsync(requset, HttpResponse.BodyHandlers.ofString()).thenAccept(response -> {
            callback.accept(response.body());

        });
    }

    public void createNewTodoItemOnServer(Consumer<String> callback) {
        var httpClient = HttpClient.newHttpClient();
        var requset = HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/todos"))
                .POST(HttpRequest.BodyPublishers.ofString("Massage to POST"))
                .build();
        httpClient.sendAsync(requset,HttpResponse.BodyHandlers.ofString()).thenAccept(response ->{
            callback.accept(response.body());
        });
    }

    private TodoDto createNewTodoItem(int id) {
        var todo = new TodoDto();
        todo.setId(id);
        todo.setCompleted(false);
        todo.setTitle("Finish the DEA Exercise");
        todo.setUserId(2);
        return todo;
    }
}
