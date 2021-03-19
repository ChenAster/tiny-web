package sample;

import com.web.Filter;
import com.web.HttpRequest;

public class LoggingFilter implements Filter {
    @Override
    public HttpRequest doFilter(HttpRequest request) {
        System.out.println("logging filter - path: " + request.getPath());
        return request;
    }
}
