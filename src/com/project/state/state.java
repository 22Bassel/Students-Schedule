package com.project.state;

import com.project.graph.graph_node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class state {


    Map<Integer,List<graph_node>> my_table =new HashMap<>();


    List<String> final_cost=new ArrayList<>();

    Double distance;

    public state() {

    }

    public state(Map<Integer, List<graph_node>> my_table) {
        this.my_table = my_table;
    }


    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public void make_table(int subject) {
        if (!my_table.containsKey(subject)) {
            my_table.put(subject, new ArrayList());
        }
    }
        public Map<Integer, List<graph_node>> getMy_table() {
        return my_table;
    }

    public void add_on_final_cost(String new_string){

        final_cost.add(new_string);

    }

    public void add_on_table(int subject, graph_node new_node){
        if(!my_table.containsKey(subject)){
            my_table.put(subject,new ArrayList());
        }
        my_table.get(subject).add(new_node);


    }

    public void setMy_table(Map<Integer, List<graph_node>> my_table) {
        this.my_table = my_table;
    }

    public List<graph_node> getMy_table(int subject) {
if(my_table.containsKey(subject)){
        return my_table.get(subject);}
else return null;
    }

    public void dlete_if_exist( graph_node delete,int id_subject){
        if(my_table.containsKey(id_subject)){
            my_table.get(id_subject).remove(delete);
        }
    }

    public List<String> getFinal_cost() {
        return final_cost;
    }
}
