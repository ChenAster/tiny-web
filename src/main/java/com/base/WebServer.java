package com.base;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class WebServer {
    final private int port;

    public WebServer(int port) {
        this.port = port;
    }

    public void run() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket;
            try {
                socket = serverSocket.accept();

                OutputStream outputStream = socket.getOutputStream();
                PrintWriter printWriter = new PrintWriter(outputStream);
                String innerText = "hello, world";
                String output = "HTTP/1.1 200 ok \r\n"
                        + "Content-Type:text/html \r\n"
                        + "Content-Length:" + innerText.length() + "\r\n"
                        + "\r\n"
                        + innerText;
                printWriter.print(output);
                printWriter.flush();
                printWriter.close();
                outputStream.close();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }
        }
    }
}
