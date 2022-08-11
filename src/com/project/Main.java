package com.project;

import com.project.H.*;
import com.project.data.*;
import com.project.graph.graph_coordinates;
import com.project.graph.graph_node;
import com.project.graph.graph_nodes_weight;
import com.project.state.state;

import java.awt.geom.Point2D;
import java.util.*;

public class Main {

    private static List<graph_node> getgraph(){

        List<graph_node> graph =new ArrayList<>();


        data mydata=new data();
        List<student_subject> subject=data.subject();

        int all_subjects =mydata.getSubject_number();
        int students_number_in_lacture =mydata.getStudents_number_in_lacture();
        Map<Integer,Integer> subjectnumber=new HashMap<>();
        Map<Integer,List<Integer>> student_in_subject=new HashMap();



        for(student_subject s :subject){
            if(!student_in_subject.containsKey(s.getSubject_number())){
                student_in_subject.put(s.getSubject_number(),new ArrayList<Integer>());
                student_in_subject.get(s.getSubject_number()).add(s.getStudent_number());
            }
            else {
                student_in_subject.get(s.getSubject_number()).add(s.getStudent_number());
            }

        }


        System.out.println("students in each subject : "+student_in_subject);


        for(student_subject s :subject){
            if(!subjectnumber.containsKey(s.getSubject_number())){
                subjectnumber.put(s.getSubject_number(),1);
            }
            else {
                subjectnumber.put(s.getSubject_number(),subjectnumber.get(s.getSubject_number())+1);
            }

        }


        System.out.println("number of students in subjects : "+subjectnumber);





        List<subject_times> schedule = mydata.schedule();




        int id=0;

//        graph.add(new graph_node(id, 0, 0, 0, 0)); /// root node


        for (int subject_num=1;subject_num<=all_subjects;subject_num++){

                        List<Integer> students= student_in_subject.get(subject_num);

                        for(int student_number_in_lec : students){

                            for(subject_times sub:schedule){

                                if(sub.getSubject()==subject_num) {
                                    id++;
                                    graph.add(new graph_node(id, subject_num, sub.getDay(), sub.getStart_time(), student_number_in_lec,sub.getis_practical()));


                                }
                            }
                        }
        }

     //   System.out.println("graph : "+graph);





        ////////////////////////////////////////
        ///////make children for all nodes
        ////////////////////////////////////////


        ////////////////////
        /// for root
        ///////////////////

        graph_node root=new graph_node(255,1,1,8,0,true);

        graph.add(root);
        int first_to_root=student_in_subject.get(1).get(0);



        for(graph_node child_root_node :graph){

            if(child_root_node.getSubject()==1 && child_root_node.getStudent_number()==first_to_root && child_root_node.isIs_practical()) {
                root.addchild(child_root_node);
//                System.out.println("child : "+child_root_node);
//
            }

        }



        ///////////////////////
        ////student with next
        //////////////////////
        int first=0;

        for (int i = 1; i <=  student_in_subject.size(); i++) {
                //int j=2;
            List<Integer> student =student_in_subject.get(i);


            for (int second:student){
                if(first!=0) {


                    for(graph_node first_node :graph){


                        if(first_node.getStudent_number()==first && first_node.getSubject()==i ){
                        for(graph_node second_node :graph) {



                            if(second_node.getStudent_number()==second
                                    && first_node.getSubject()==second_node.getSubject()
                                    && ((second_node.isIs_practical()&&first_node.isIs_practical()) || (!second_node.isIs_practical()&&!first_node.isIs_practical()))) {

                                first_node.addchild(second_node);

                            }

                        }
                        }
                    }

                }

            first=second;
            }


        }





        ///////////////////////////////////////////////
        //////end first with start next
        ///////////////////////////////////////////////


        for (int i = 2; i <= student_in_subject.size(); i++) {

            int j=i-1;

            List<Integer> student1 =student_in_subject.get(j);

       //     System.out.println(student1);
            //System.out.println(student1.size());




            int last_in_first=student1.get((student1.size())-1);

            List<Integer> student2 =student_in_subject.get(i);

            int first_in_second=student2.get(0);




            for(graph_node first_node :graph){


                if(first_node.getStudent_number()==last_in_first && first_node.getSubject()==j){
                    for(graph_node second_node :graph) {



                        if(second_node.getStudent_number()==first_in_second
                                && second_node.getSubject()==i

                                && ((second_node.isIs_practical()&&first_node.isIs_practical()) || (!second_node.isIs_practical()&&!first_node.isIs_practical()))) {

                            // System.out.println("22 dad : " + first_node + " , child : " + second_node);
                            first_node.addchild(second_node);

                        }

                    }
                }


            }
        }




        ////////////////////////////////
        ///end practical with start the
        ////////////////////////////////

        List<Integer> student1 =student_in_subject.get(1);
        List<Integer> student2 =student_in_subject.get(student_in_subject.size());



        int first_in_first= student1.get(0);

        int last_in_last= student2.get(student2.size()-1);



        for(graph_node first_node :graph) {


            if (first_node.getStudent_number() == last_in_last && first_node.getSubject()== student_in_subject.size()) {
                for (graph_node second_node : graph) {

                    if (second_node.getStudent_number() == first_in_first
                            && second_node.getSubject() == 1
                            && (first_node.isIs_practical() && !second_node.isIs_practical())){
                       //  System.out.println("33 dad : " + first_node + " , child : " + second_node);
                        first_node.addchild(second_node);



                    }
                }

            }
        }



        return graph;
    }




/**
    private static graph_nodes_weight graph_nodes_weight(List<graph_node> graph){

        graph_nodes_weight weights=new graph_nodes_weight();


        data mydata=new data();

        List<student_day> day_cant_come=mydata.day_cant_come();

        List<student_times> times_not_prefer=mydata.times_not_prefer();

        List<student_times> times_prefer=mydata.times_prefer();


        for (graph_node node :graph){
            for (graph_node child :node.getChildren()){

                double cost=100;

                for(student_day s :day_cant_come){

                if(s.getStudent_number()==child.getStudent_number() && s.getDay()==child.getDay()){

                    cost+=1000;
                    }
                }

                for(student_times s :times_not_prefer){

                    if(s.getStudent_number()==child.getStudent_number() && s.getDay()==child.getDay() && s.getTime()==child.getStart_time()){

                        cost+=100;
                    }

                }


                for(student_times s :times_prefer){

                    if(s.getStudent_number()==child.getStudent_number() && s.getDay()==child.getDay() && s.getTime()==child.getStart_time()){

                        cost-=100;
                    }

                }





                //System.out.println("node : "+node +" ,child : "+child+ " ,cost : "+cost);
            weights.set_one_wight(node,child,cost);


        }

        }

        return weights;
    }

**/
    public static void main(String[] args) {




        List<graph_node> graph =getgraph();



   //     graph_nodes_weight weights=graph_nodes_weight(graph);





        ////////////////////////
        ///root
        ///////////////////////

        data mydata=new data();
        List<subject_times> schedule = mydata.schedule();

        System.out.println("root : "+graph.get(graph.size()-1));
        System.out.println("end : "+graph.get((292)));

      //  H_function h1=new zero_H_function();
      //  H_function h1=new max_arc_H();
       // H_function h1=new minimal_ecah_arc_H();
        H_function h1=new maximal_each_arc_H();

        //
        state last_state= A_star.search(graph.get(graph.size()-1),graph.get((292)),h1);


        if(last_state!=null){

        System.out.println("final cost = "+last_state.getDistance());
        System.out.println("cost with details : ");
        List<String> cost_=last_state.getFinal_cost();

        cost_.forEach(System.out::println);


        long end=System.currentTimeMillis();

        int all_subjects =mydata.getSubject_number();
        Map<Integer,Map<Integer,Map<Integer,List<Integer>>>> subjectnumber_th=new HashMap<>(); //subject //day  // time //list student
        Map<Integer,Map<Integer,Map<Integer,List<Integer>>>> subjectnumber_pa=new HashMap<>();

            for (int i = 1; i <= all_subjects; i++) {

                List<graph_node> path = last_state.getMy_table(i);

                for (graph_node g : path) {
                    if(g.isIs_practical()){

                        if(!subjectnumber_pa.containsKey(g.getSubject())) {
                            subjectnumber_pa.put(g.getSubject(),new HashMap<>());
                        }
                        if(!subjectnumber_pa.get(g.getSubject()).containsKey(g.getDay()))
                        {
                            subjectnumber_pa.get(g.getSubject()).put(g.getDay(),new HashMap<>());
                        }
                        if(!subjectnumber_pa.get(g.getSubject()).get(g.getDay()).containsKey(g.getStart_time())){
                            subjectnumber_pa.get(g.getSubject()).get(g.getDay()).put(g.getStart_time(),new ArrayList<>());
                        }

                        subjectnumber_pa.get(g.getSubject()).get(g.getDay()).get(g.getStart_time()).add(g.getStudent_number());

                    }
                    else {
                        if(!subjectnumber_th.containsKey(g.getSubject())) {
                            subjectnumber_th.put(g.getSubject(),new HashMap<>());
                        }
                        if(!subjectnumber_th.get(g.getSubject()).containsKey(g.getDay()))
                        {
                            subjectnumber_th.get(g.getSubject()).put(g.getDay(),new HashMap<>());
                        }
                        if(!subjectnumber_th.get(g.getSubject()).get(g.getDay()).containsKey(g.getStart_time())){
                            subjectnumber_th.get(g.getSubject()).get(g.getDay()).put(g.getStart_time(),new ArrayList<>());
                        }

                        subjectnumber_th.get(g.getSubject()).get(g.getDay()).get(g.getStart_time()).add(g.getStudent_number());

                    }

                    }
                }


            System.out.println();



            System.out.println(" students in practical subjects : "+subjectnumber_pa);

            System.out.println(" students in theortic subjects : "+subjectnumber_th);


/**
            for (int i = 1; i <= all_subjects; i++) {

        System.out.println("subject ( "+i+" ) : ");
        List<graph_node> path=last_state.getMy_table(i);

        path.forEach(System.out::println);
        System.out.println();
                System.out.println("the end time = "+end);

                System.out.println("total time  = "+(end-start));

            }**/
        }
        else {
            System.out.println("there is no solution !!! ");

        }



    }

}
