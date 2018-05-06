package com.ruaco.tinyweb.sample;

import com.ruaco.tinyweb.*;
import com.ruaco.tinyweb.sample.LoggingFilter;
import com.ruaco.tinyweb.sample.SampleController;
import com.ruaco.tinyweb.sample.SampleRenderStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * test entrance
 * */
public class SampleMain {
    public static void main(String[] args) {

        TinyWeb web = webInit();
        HttpRequest request = requestInit();
        HttpResponse response = web.handleRequest(request);
        System.out.println(response);
    }

    private static TinyWeb webInit() {

        SampleRenderStrategy strategy = new SampleRenderStrategy();
        View view = new StrategyView(strategy);
        SampleController controller = new SampleController(view);
        Filter loggerFilter = new LoggingFilter();

        Map<String, Controller> controllers = new HashMap<String, Controller>();
        List<Filter> filters = new ArrayList<Filter>();

        controllers.put("sample", controller);
        filters.add(loggerFilter);

        return new TinyWeb(controllers, filters);
    }

    private static HttpRequest requestInit() {
        return new HttpRequest.Builder().builderNew().path("sample").body("this is body").build();
    }
}
