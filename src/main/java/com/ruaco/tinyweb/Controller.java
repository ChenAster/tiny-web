package com.ruaco.tinyweb;

public interface Controller {

    public HttpResponse handleRequest(HttpRequest httpRequest);
}
