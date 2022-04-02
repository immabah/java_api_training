package fr.lernejo.navy_battle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class HttpServer_navyTest {
    @Test
    public void PingTest() throws IOException, InterruptedException {
        HttpServer_navy server = new HttpServer_navy(9876, "localhost");
        server.start();
        HttpResponse<String> rcv = null;
        HttpRequest requestGet = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:9876/ping"))
            .setHeader("Accept", "application/json")
            .build();
        rcv = HttpClient.newHttpClient().send(requestGet, HttpResponse.BodyHandlers.ofString());
        Assertions.assertEquals(200, rcv.statusCode());
        HttpClient.newHttpClient().send(requestGet, HttpResponse.BodyHandlers.ofString());
    }
}

