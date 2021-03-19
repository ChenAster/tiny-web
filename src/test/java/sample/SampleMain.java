package sample;

import com.web.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * test entrance
 * */
public class SampleMain {
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

    private static HttpRequest requestInit(String path) {
        return new HttpRequest.Builder().builderNew().path(path).body("this is body").build();
    }

    @Test
    public void web200() {
        TinyWeb web = webInit();
        HttpRequest request = requestInit("sample");
        HttpResponse response = web.handleRequest(request);
        Assert.assertEquals(200, response.getResponseCode().intValue());
        System.out.println(response.getBody());
    }

    @Test
    public void web500() {
        TinyWeb web = webInit();
        HttpRequest request = requestInit("test");
        HttpResponse response = web.handleRequest(request);
        Assert.assertEquals(500, response.getResponseCode().intValue());
        System.out.println(response.getBody());
    }

}
