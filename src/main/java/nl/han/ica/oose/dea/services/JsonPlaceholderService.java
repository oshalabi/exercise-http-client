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
    private HttpClient httpClient;
    private String jasonUrlTodos;
    public JsonPlaceholderService() {
        todoMapper = new TodoMapper();
        httpClient = HttpClient.newHttpClient();
        jasonUrlTodos = "https://jsonplaceholder.typicode.com/todos";
    }

    public void getTodos() {

        var requset = HttpRequest.newBuilder().uri(URI.create(jasonUrlTodos)).build();

            httpClient.sendAsync(requset, HttpResponse.BodyHandlers.ofString()).thenAccept(response -> {
                        System.out.println(response.body());
                    }
            );
    }

    public void getTodosWithCallback(Consumer<String> callback) {

        var requset = HttpRequest.newBuilder().uri(URI.create(jasonUrlTodos)).build();
        httpClient.sendAsync(requset, HttpResponse.BodyHandlers.ofString()).thenAccept(response -> {
            callback.accept(response.body());

        });
    }

    public void createNewTodoItemOnServer(Consumer<String> callback) {

        var requset = HttpRequest.newBuilder().uri(URI.create(jasonUrlTodos))
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
