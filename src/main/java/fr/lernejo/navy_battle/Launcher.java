package fr.lernejo.navy_battle;

import java.io.IOException;

public class Launcher {

    public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length < 1) {
            System.err.println("Please add a port");
        }
        else if (args.length == 1) {
            HttpServer_navy server = new HttpServer_navy(Integer.parseInt(args[0]), "");
            server.start();
        }
        else {
            HttpServer_navy server2 = new HttpServer_navy(Integer.parseInt(args[0]), args[1]);
            server2.start();
        }

    }
}

