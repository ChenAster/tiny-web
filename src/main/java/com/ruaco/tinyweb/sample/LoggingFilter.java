package com.ruaco.tinyweb.sample;

import com.ruaco.tinyweb.Filter;
import com.ruaco.tinyweb.HttpRequest;

public class LoggingFilter implements Filter {
    @Override
    public HttpRequest doFilter(HttpRequest request) {
        System.out.println("logging filter - path: " + request.getPath());
        System.out.println("----------");
        return request;
    }
}
