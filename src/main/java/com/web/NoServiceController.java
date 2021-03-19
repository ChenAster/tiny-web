package com.web;

public class NoServiceController implements Controller {
    @Override
    public HttpResponse handleRequest(HttpRequest httpRequest) {
        Integer responseCode = 500;
        String responseBody = "path is invalid.";
        return HttpResponse.Builder.builderNew()
                .body(responseBody)
                .responseCode(responseCode)
                .build();
    }

    private NoServiceController() {
        // use getInstance to init
    }

    public static Controller getInstance() {
        return new NoServiceController();
    }
}
