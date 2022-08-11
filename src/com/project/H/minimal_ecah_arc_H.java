package com.project.H;

import com.project.get_next_state;
import com.project.graph.graph_node;
import com.project.graph.graph_nodes_weight;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class minimal_ecah_arc_H implements H_function{

    private get_next_state next_state;


    public minimal_ecah_arc_H() {
next_state=new get_next_state();

    }


    @Override
    public double get_Estimate(graph_node first, graph_node second, Map<graph_node,graph_node> parent) {

        graph_node current=first;
        double cost=0;

        graph_node last_current=second;
        Set<graph_node> close = new HashSet<>();

        while (current!=second) {


//            System.out.println("sadasdad"+current);

            double min_cost=5000;
            graph_node child=null;

            for (graph_node g : current.getChildren()) {
                if(close.contains(g)){continue;}

                if(next_state.getweights(current,g,parent)<min_cost){
                    child=g;
                    min_cost=next_state.getweights(current,g,parent);
                }
                close.add(g);

            }

            if(child==null){break;}

            if(last_current.equals(current)){
                break;
            }
            last_current=current;

            cost+=min_cost;
            current=child;



        }
//        System.out.println("cost : "+cost);
    return cost;
    }
}
