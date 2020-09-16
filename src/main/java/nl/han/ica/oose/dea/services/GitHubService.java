package nl.han.ica.oose.dea.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GitHubService {

    public String getIndexHtml(){

            var httpClient = HttpClient.newHttpClient();
            var requset = HttpRequest.newBuilder().uri(URI.create("https://github.com/")).build();

        HttpResponse<String> response = null;
        try {
            response = httpClient.send(requset, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return response.body();

    }

    public String getReadme() {

        var httplClient = HttpClient.newHttpClient();
        var requset = HttpRequest.newBuilder().uri(URI.create("https://raw.githubusercontent.com/HANICA-DEA/exercise-http-client/master/README.md")).build();

        HttpResponse<String> response = null;
        try{
            response = httplClient.send(requset, HttpResponse.BodyHandlers.ofString());
        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return response.body();
    }
}
