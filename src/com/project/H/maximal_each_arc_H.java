package com.project.H;

import com.project.get_next_state;
import com.project.graph.graph_node;
import com.project.graph.graph_nodes_weight;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class maximal_each_arc_H implements H_function{

    private get_next_state next_state;


    public maximal_each_arc_H() {
        next_state=new get_next_state();


    }


    @Override
    public double get_Estimate(graph_node first, graph_node second, Map<graph_node,graph_node> parent) {

        graph_node current=first;
        double cost=0;

        graph_node last_current=second;
        Set<graph_node> close = new HashSet<>();

//        System.out.println("sadasdad");
        while (current!=second) {


  //          System.out.println("sadasdad"+current);

            double max_cost=0;
            graph_node child=null;

            for (graph_node g : current.getChildren()) {
                if(close.contains(g)){continue;}

                if(next_state.getweights(current,g,parent)>max_cost){
                    child=g;
                    max_cost=next_state.getweights(current,g,parent);
                }
                close.add(g);

            }

            if(child==null){break;}

            if(last_current.equals(current)){
                break;
            }
            last_current=current;

            cost+=max_cost;
            current=child;



        }

        return cost;
    }
}
