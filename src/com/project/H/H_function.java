package com.project.H;

import com.project.graph.graph_node;

import java.util.Map;

public interface H_function {
    public double get_Estimate(graph_node first, graph_node second, Map<graph_node,graph_node> parent);
}
