package fr.lernejo.navy_battle;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientFire {
    private final HttpClient Clt = HttpClient.newHttpClient();


    public void Clientfire(String url, String cell) {
        String requestPt = url + "/api/game/fire?cell=" + cell;
        HttpRequest getRequest = HttpRequest.newBuilder().uri(URI.create(requestPt))
            .setHeader("Accept", "application/json")
            .setHeader("Content-Type", "application/json").GET().build();

        try {
            HttpResponse<String> response = Clt.send(getRequest, HttpResponse.BodyHandlers.ofString());

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}

