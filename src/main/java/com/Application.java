package com;

import com.base.WebServer;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        int port = 8100;
        WebServer webServer = new WebServer(port);
        try {
            webServer.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
