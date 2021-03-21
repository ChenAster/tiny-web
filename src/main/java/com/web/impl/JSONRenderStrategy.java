package com.web.impl;

import com.google.gson.Gson;
import com.web.RenderStrategy;

import java.util.List;
import java.util.Map;

public class JSONRenderStrategy implements RenderStrategy {
    @Override
    public String renderView(Map<String, List<String>> model) {
        Gson gson = new Gson();
        return gson.toJson(model);
    }
}
