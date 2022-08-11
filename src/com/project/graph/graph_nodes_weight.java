package com.project.graph;

import java.util.HashMap;
import java.util.Map;

public class graph_nodes_weight {

    private final Map<graph_node,Map<graph_node,Double>> weights=new HashMap<>();

    public  void set_one_wight(graph_node first,graph_node second ,double the_wight){
        if(!weights.containsKey(first)) {
            weights.put(first, new HashMap<>());
        }
        weights.get(first).put(second,the_wight);

    }


    public double get(graph_node first,graph_node second){
        return weights.get(first).get(second);
    }





    @Override
    public String toString(){
        return "\n n "+ weights.get(this);
    }

}
