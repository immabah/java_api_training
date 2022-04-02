package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer_navy {
    private final HttpServer server;

    public HttpServer_navy(int port, String link) throws IOException, InterruptedException {
        this.server = HttpServer.create(new InetSocketAddress(port), 1);
        ExecutorService executorService = Executors.newFixedThreadPool(1);//Executors.newSingleThreadExecutor();
        this.server.setExecutor(executorService);
        server.createContext("/ping").setHandler(new HttpPingHandler());
        server.createContext("/api/game/start").setHandler(new HttpPostHandler(port,""));
        server.createContext("/api/game/fire").setHandler(new HttpFireHdl(port));
    }

    public void start() {
        this.server.start();
    }
}
