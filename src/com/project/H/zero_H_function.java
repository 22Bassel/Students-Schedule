package com.project.H;

import com.project.graph.graph_node;

import java.util.Map;

public class zero_H_function implements H_function {


    @Override
    public double get_Estimate(graph_node first, graph_node second, Map<graph_node,graph_node> parent) {
        return 0.0;
    }
}
