package com.web.impl.filter;

import com.web.Filter;
import com.web.HttpRequest;

public class BlankFilter implements Filter {

    @Override
    public HttpRequest doFilter(HttpRequest request) {
        return request;
    }
}
