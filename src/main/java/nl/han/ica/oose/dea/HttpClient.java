package nl.han.ica.oose.dea;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import nl.han.ica.oose.dea.services.AlbumService;
import nl.han.ica.oose.dea.services.CommentsService;

import java.util.Scanner;

/**
 * Hello world!
 */
public class HttpClient {

    public static final String URL_ROOT = "https://jsonplaceholder.typicode.com";

    public static void main(String[] args) {
        var httpClient = new HttpClient();
        httpClient.start();
    }

    private void start() {
        var keyboard = new Scanner(System.in);

        var almbumService = new AlbumService();
        var commentsService = new CommentsService();

        boolean exit = false;
        while (!exit) {
            printSelectionScreen();
            var input = keyboard.nextLine();
            if (input != null) {
                System.out.println("> You have selected : " + input);
                if ("quit".equals(input)) {
                    System.out.println("> Exit programm");
                    exit = true;
                } else if ("1".equals(input)) {
                    System.out.println(createPrettyString(commentsService.getAllComments()));
                }
            }
        }
        keyboard.close();
    }

    private void printSelectionScreen() {
        System.out.println("------------------------------------------------");
        System.out.println("| Welcome to the HTTP-Client");
        System.out.println("------------------------------------------------");
        System.out.println("| Please select which request to send: ");
        System.out.println("|");
        System.out.println("| * Press 1 for a GET to /comments");
        System.out.println("| * Press 1 for a POST to /comments");
        System.out.println("| * Press 1 for a DELETE to /comments");
        System.out.println("|");
        System.out.println("| * Press quit to exit");
        System.out.print("> ");
    }

    private String createPrettyString(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(json);
        String prettyJson = gson.toJson(je);
        return "Received response: \n".concat(prettyJson);
    }
}
