package com;

import com.base.WebServer;
import com.web.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        TinyWeb tinyWeb = webInit();

        int port = 8100;
        WebServer webServer = new WebServer(port, tinyWeb);
        try {
            webServer.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TinyWeb webInit() {
        Map<String, Controller> controllers = new HashMap<>();
        List<Filter> filters = new ArrayList<>();
        return new TinyWeb(controllers, filters);
    }
}
