package fr.lernejo.navy_battle;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClient_navy {
    private final HttpClient client;
    public final int port;
    public final String url;
    public HttpClient_navy(int port, String url) {
        this.client = HttpClient.newHttpClient();
        this.port = port;
        this.url = url;

    }

    public void SendStart() throws IOException, InterruptedException {
        HttpRequest requestPost = HttpRequest.newBuilder()
            .uri(URI.create(url + "/api/game/start"))
            .setHeader("Accept", "application/json")
            .setHeader("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString("{\"id\":\"1\", \"url\":\"http://localhost:" + this.port + "\", \"message\":\"hello\"}")).build();

        try{
            this.client.sendAsync(requestPost, HttpResponse.BodyHandlers.ofString()).thenAccept(r -> System.out.println("Reply: " +
                r.statusCode() + " : " + r.body()));        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }
}
