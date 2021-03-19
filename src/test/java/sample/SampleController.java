package sample;

import com.web.HttpRequest;
import com.web.TemplateController;
import com.web.View;

import java.util.*;

public class SampleController extends TemplateController {

    public SampleController(View view) {
        super(view);
    }

    @Override
    protected Map<String, List<String>> doRequest(HttpRequest request) {
        Map<String, List<String>> model = new HashMap<String, List<String>>();
        model.put("sample", generateBody());
        return model;
    }

    private List<String> generateBody() {
        return Arrays.asList("message-1", "message-2", "message-3");
    }
}
