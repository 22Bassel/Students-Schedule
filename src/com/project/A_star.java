package com.project;

import com.project.H.H_function;
import com.project.data.data;
import com.project.data.student_subject;
import com.project.data.subject_times;
import com.project.graph.graph_node;
import com.project.graph.graph_nodes_weight;
import com.project.state.one_state;
import com.project.state.state;

import java.util.*;

public class A_star {

    private static final class entry implements Comparable<entry> {
        private final graph_node mynode;
        private final double distance;

        private entry(graph_node mynode, double distance) {
            this.mynode = mynode;
            this.distance = distance;
        }

        @Override
        public int compareTo(entry o) {
            return Double.compare(distance, o.distance);
        }


        public graph_node get_graph_node() {
            return mynode;
        }

        public entry get_entry() {
            return this;
        }

        public double get_distance() {
            return distance;
        }

    }


    static List<graph_node> get_the_path(graph_node current, Map<graph_node, graph_node> parent) {
        List<graph_node> the_path = new ArrayList<>();
        graph_node mycurrent = current;

        while (mycurrent != null) {
            the_path.add(mycurrent);
            mycurrent = parent.get(mycurrent);
        }

        return the_path;
    }

    static boolean in_parent(Map<graph_node, graph_node> parent,graph_node child){

        graph_node mycurrent = child;

        while (mycurrent != null) {

            if(mycurrent.getStudent_number()==child.getStudent_number())
            {
                return true;

            }

            mycurrent = parent.get(mycurrent);
        }
                return false;
    }

    static boolean find_a_goal( Map<graph_node, graph_node> parent,graph_node child,  Map<Integer,List<Integer>> student_in_subject) {





        boolean found_first = false;

        boolean found_second = false;
        for (int i = 1; i <= student_in_subject.size(); i++) {


            List<Integer> students = student_in_subject.get(i);

            for (int student : students) {
                found_first = false;
                found_second=false;

                graph_node mycurrent = child;

                while (mycurrent != null) {

                    if (mycurrent.getStudent_number() == student && mycurrent.getSubject()==i) {

                        if(found_second){

                            found_first=true;
                            break;

                        }
                        found_second = true;

                    }

                    mycurrent = parent.get(mycurrent);
                }

                if (!found_first) {
                    return false;
                }
            }
        }

        return true;

    }


    public static state search(graph_node root_node, graph_node goal_node, H_function h_function) {


        int open_visited=0;
        int open_add=0;


        get_next_state get_next_state = new get_next_state();

        data mydata = new data();



        PriorityQueue<entry> open = new PriorityQueue<>();
        Set<graph_node> close = new HashSet<>();

        Map<graph_node, Double> distance = new HashMap<>(); ////student number

        Map<graph_node,graph_node> parent = new HashMap<>();

        state all_states = new state();


        double fscore = 0;


        //List<subject_times> schedule = mydata.schedule();

        //state last_state = new state();

        entry statr=new entry(root_node,0);
        open.add(statr);
        distance.put(root_node, 0d);

        parent.put(root_node, null);



        Map<Integer,List<Integer>> student_in_subject=new HashMap();

        List<student_subject> subject=data.subject();

        for(student_subject s :subject){
            if(!student_in_subject.containsKey(s.getSubject_number())){
                student_in_subject.put(s.getSubject_number(),new ArrayList<Integer>());
                student_in_subject.get(s.getSubject_number()).add(s.getStudent_number());
            }
            else {
                student_in_subject.get(s.getSubject_number()).add(s.getStudent_number());
            }

        }







        ///////////////////////////////////////////////////////////////////



        while (!open.isEmpty()) {

            entry current = open.poll();

            if (find_a_goal(parent, current.get_graph_node() ,student_in_subject)) {


                System.out.println();
                System.out.println(" the number of added nodes in open : "+open_add);
                System.out.println(" the number of visisted nodes in open : "+open_visited);



                all_states.setDistance(distance.get(current.get_graph_node()));

                return all_states;
            }
            if(close.contains(current.get_graph_node())){continue;}

            close.add(current.get_graph_node());



            open_visited++;

            for (graph_node child : (current.get_graph_node()).getChildren()) {



                if(child.getStudent_number()==0){continue;}






                double new_destance = distance.get(current.get_graph_node()) + get_next_state.getweights(current.get_graph_node(), child, parent);



                state temp_states=get_next_state.check_make_new(child,current.get_graph_node(),all_states,parent);

                if ((!distance.containsKey(child) || distance.get(child) > new_destance )&& temp_states!=null ) {


                    distance.put(child, new_destance);
                    parent.put(child,current.get_graph_node());

                    open.add(new entry(child , new_destance + h_function.get_Estimate(child,goal_node,parent)));

                    open_add++;

                    all_states=temp_states;






                }

            }




        }
        return null;
        }




}