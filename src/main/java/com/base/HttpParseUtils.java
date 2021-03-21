package com.base;

import com.web.HttpRequest;
import com.web.HttpResponse;

public class HttpParseUtils {

    public static HttpRequest httpRequest(String request) {
        HttpRequest req = new HttpRequest.Builder()
                .build();
        return req;
    }

    public static String httpResponse(HttpResponse httpResponse) {
        return httpResponse.toString();
    }
}
