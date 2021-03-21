package com.base;

import com.web.HttpRequest;
import com.web.HttpResponse;

public class HttpParseUtils {

    public static HttpRequest processHttpRequest(String request) {
        String[] rawData = request.split("\r\n\r\n");
        String headerStr = rawData[0];
        String body = null;
        if (rawData.length > 1) {
            body = rawData[1];
        }

        String[] parts = headerStr.split(" ");
        String path = parts[1];

        return new HttpRequest.Builder()
                .path(path)
                .body(body)
                .build();
    }

    public static String processHttpResponse(HttpResponse httpResponse) {
        int statusCode = httpResponse.getResponseCode();
        String body = httpResponse.getBody();

        return "HTTP/1.1 " + statusCode + " ok \r\n"
                + "Content-Type:text/html \r\n"
                + "Content-Length:" + body.length() + "\r\n"
                + "\r\n"
                + body;
    }
}
