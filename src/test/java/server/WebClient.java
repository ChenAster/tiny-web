package server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class WebClient {

    public static void main(String[] args) {
        Socket socket;
        try {
            socket = new Socket("127.0.0.1", 8100);

            OutputStream socketOutput = socket.getOutputStream();
            String request = "GET /testcase HTTP/1.1\r\n";
            socketOutput.write(request.getBytes());
            socketOutput.flush();

            InputStream socketReceive = socket.getInputStream();
            StringBuilder charList = new StringBuilder();
            int nRead;
            while((nRead = socketReceive.read()) != -1) {
                charList.append((char)nRead);
            }
            System.out.println(charList.toString());
            socketOutput.close();
            socketReceive.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
