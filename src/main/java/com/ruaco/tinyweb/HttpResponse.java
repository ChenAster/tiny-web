package com.ruaco.tinyweb;

public class HttpResponse {
    private final String body;
    private final Integer responseCode;

    public String getBody() {
        return body;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    private HttpResponse(Builder builder) {
        this.body = builder.body;
        this.responseCode = builder.responseCode;
    }

    @Override
    public String toString() {
        return String.format("response code: %s\nresponse body:\n%s\n",
                this.responseCode,
                this.body);
    }

    public static class Builder {
        private String body;
        private Integer responseCode;

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder responseCode(Integer code) {
            this.responseCode = code;
            return this;
        }

        public HttpResponse build() {
            return new HttpResponse(this);
        }

        public static Builder builderNew() {
            return new Builder();
        }
    }
}
