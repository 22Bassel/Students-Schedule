package com.project.H;

import com.project.get_next_state;
import com.project.graph.graph_node;
import com.project.graph.graph_nodes_weight;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class max_arc_H implements H_function{
    private get_next_state next_state;

    public max_arc_H(){
        next_state=new get_next_state();
    }

    @Override
    public double get_Estimate(graph_node first, graph_node second, Map<graph_node,graph_node>parent) {
        graph_node current=first;

        graph_node last_current=second;
        Set<graph_node> close = new HashSet<>();


        int numbers=0;
        double cost=0;
        double max_cost=0;
      //  System.out.println("111111111111AAAAA");
        while (current!=second) {
            //System.out.println("333333333333AAAAA"+current);
            graph_node child=null;

            numbers++;
            for (graph_node g : current.getChildren()) {

                if(close.contains(g)){continue;}
             //   System.out.println("44444444444AAAAA"+g);
                if(next_state.getweights(current,g,parent)>max_cost && next_state.getweights(current,g,parent)!=1000){
                    child=g;
                    max_cost=next_state.getweights(current,g,parent);
                }
                child=g;
                close.add(g);
            }

            if(child==null){break;}

            if(last_current.equals(current)){
                break;
            }
            last_current=current;
            current=child;
        }


        cost=numbers*max_cost;

        //System.out.println("number : "+cost);
        return cost;
    }

}

