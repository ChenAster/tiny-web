package com.web;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {

    private final String path;
    private final String body;
    private final Map<String, String> headers;

    public String getPath() {
        return path;
    }

    public String getBody() {
        return body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public HttpRequest(Builder builder) {
        this.path = builder.path;
        this.body = builder.body;
        this.headers = builder.headers;
    }

    public static Builder builderFrom(HttpRequest request) {
        Builder builder = new Builder();
        builder.path(request.getPath());
        builder.body(request.getBody());

        Map<String, String> headers = request.getHeaders();
        for (String headerName : headers.keySet()) {
            builder.addHeader(headerName, headers.get(headerName));
        }
        return builder;
    }

    public static class Builder {
        private String path;
        private String body;
        private Map<String, String> headers = new HashMap<String, String>();

        public Builder path(String path) {
            this.path = path;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder addHeader(String key, String value) {
            this.headers.put(key, value);
            return this;
        }

        public HttpRequest build() {
            return new HttpRequest(this);
        }

        public Builder builderNew() {
            return new Builder();
        }
    }
}
