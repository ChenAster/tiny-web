package com.web;

import java.util.List;
import java.util.Map;

public interface RenderStrategy {

    String renderView(Map<String, List<String>> model);
}
