package sample;

import com.ruaco.tinyweb.RenderingStrategy;

import java.util.List;
import java.util.Map;
/**
 * route = sample
 * */
public class SampleRenderStrategy implements RenderingStrategy {

    @Override
    public String renderView(Map<String, List<String>> model) {
        List<String> messages = model.get("sample");
        StringBuilder responseBody = new StringBuilder();
        responseBody.append("<h1>sample</h1>\n");
        for (String m : messages) {
            responseBody.append(
                    String.format("<h2>%s</h2>\n", m)
            );
        }
        return responseBody.toString();
    }
}
