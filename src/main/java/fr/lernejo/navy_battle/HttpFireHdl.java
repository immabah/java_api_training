package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class HttpFireHdl  implements HttpHandler {
    public final int port;

    public HttpFireHdl(int port) {
        this.port = port;

    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
       // exchange.sendResponseHeaders(code, response.length());
        if (exchange.getRequestMethod().equals("GET")) {
            String msg = "{\"consequence\":\"sunk\",\"shipLeft\":true}";
            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(202, msg.getBytes().length);

        } else {
            exchange.sendResponseHeaders(404, "Error".length());

            try (OutputStream os = exchange.getResponseBody()) {
                os.write("Null".getBytes());
            }

        }
    }



}
