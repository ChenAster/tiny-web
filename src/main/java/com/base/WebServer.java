package com.base;

import com.web.HttpRequest;
import com.web.HttpResponse;
import com.web.TinyWeb;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    final private int port;
    final private TinyWeb web;

    public WebServer(int port, TinyWeb web) {
        this.port = port;
        this.web = web;
    }

    public void run() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket;
            try {
                socket = serverSocket.accept();

                InputStream inputStream = socket.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(inputStream);
                StringBuilder builder = new StringBuilder();
                while (bis.available() > 0) {
                    char ch = (char)bis.read();
                    builder.append(ch);
                }
                HttpRequest request = HttpParseUtils.processHttpRequest(builder.toString());
                HttpResponse response = web.handleRequest(request);
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.print(HttpParseUtils.processHttpResponse(response));
                printWriter.flush();
                printWriter.close();
                outputStream.close();
                inputStream.close();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
