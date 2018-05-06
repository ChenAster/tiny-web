package com.ruaco.tinyweb;

import com.ruaco.tinyweb.exception.ControllerException;
import com.ruaco.tinyweb.exception.RenderingException;

import java.util.List;
import java.util.Map;

public abstract class TemplateController implements Controller {

    private View view;

    public TemplateController(View view) {
        this.view = view;
    }

    @Override
    public HttpResponse handleRequest(HttpRequest request) {
        Integer responseCode = 200;
        String responseBody = "";

        try {
            Map<String, List<String>> model = doRequest(request);
            responseBody = view.render(model);
        }catch (ControllerException e) {
            responseCode = e.getStatusCode();
        }catch (RenderingException e) {
            responseCode = 500;
            responseBody = "Exception while rendering page.";
        }catch (Exception e) {
            responseCode = 500;
        }

        return HttpResponse.Builder.builderNew()
                .body(responseBody).responseCode(responseCode)
                .build();
    }

    protected abstract Map<String, List<String>> doRequest(HttpRequest request);
}
