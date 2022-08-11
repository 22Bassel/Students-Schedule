package com.project;

import com.project.data.data;
import com.project.data.student_day;
import com.project.data.student_times;
import com.project.graph.graph_node;
import com.project.graph.graph_nodes_weight;
import com.project.state.one_state;
import com.project.state.state;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class get_next_state {

    data mydata=new data();
    int students_number_in_lacture=mydata.getStudents_number_in_lacture();

   public state check_make_new (graph_node new_to_add,graph_node father,state current, Map<graph_node,graph_node> parent ){

       if(getweights(father,new_to_add,parent)==1000){  return null; }
        state new_one=new state();


       Map<Integer,Map<Integer,Map<Integer,Integer>>> subjects_times=new HashMap<>(); // 1 subject ,2 day ,3 time ,4 number of student







        /////////////////////////////////////////////
       // out of range  // students_number_in_lacture
       //////////////////////////////////////////////


       ////////////////////////
       ///////practical
       ///////////////////////

       graph_node mycurrent=father;

       while (mycurrent != null) {

           if(!mycurrent.isIs_practical()){
               mycurrent = parent.get(mycurrent);
               continue;
           }

           if(mycurrent.getStudent_number()==0){
               mycurrent = parent.get(mycurrent);
               continue;
           }

           if(!subjects_times.containsKey(mycurrent.getSubject()))
           {
               subjects_times.put(mycurrent.getSubject(),new HashMap());
           }

           if(!subjects_times.get(mycurrent.getSubject()).containsKey(mycurrent.getDay())){
               subjects_times.get(mycurrent.getSubject()).put(mycurrent.getDay(),new HashMap());
           }

           if(!subjects_times.get(mycurrent.getSubject()).get(mycurrent.getDay()).containsKey(mycurrent.getStart_time())){

               subjects_times.get(mycurrent.getSubject()).get(mycurrent.getDay()).put(mycurrent.getStart_time(),1);

           }
           else {
               subjects_times.get(mycurrent.getSubject()).get(mycurrent.getDay()).put(mycurrent.getStart_time(),(subjects_times.get(mycurrent.getSubject()).get(mycurrent.getDay()).get(mycurrent.getStart_time()))+1);

           }



        //   System.out.println(" : : "+mycurrent);
           mycurrent = parent.get(mycurrent);
       }


       if(subjects_times.containsKey(new_to_add.getSubject())) {
           if (subjects_times.get(new_to_add.getSubject()).containsKey(new_to_add.getDay())) {
               if (subjects_times.get(new_to_add.getSubject()).get(new_to_add.getDay()).containsKey(new_to_add.getStart_time())) {




                   if (subjects_times.get(new_to_add.getSubject()).get(new_to_add.getDay()).get(new_to_add.getStart_time()) >= students_number_in_lacture) {

                       return null;
                   }
               }
           }
       }




       /////////////////////////////
       /////////// th
       ////////////////////////////






       subjects_times=null;

       subjects_times=new HashMap<>();
        mycurrent=father;

       while (mycurrent != null) {

           if(mycurrent.isIs_practical()){
               mycurrent = parent.get(mycurrent);
               continue;
           }

           if(mycurrent.getStudent_number()==0){
               mycurrent = parent.get(mycurrent);
               continue;}

           if(!subjects_times.containsKey(mycurrent.getSubject()))
           {
               subjects_times.put(mycurrent.getSubject(),new HashMap());
           }

           if(!subjects_times.get(mycurrent.getSubject()).containsKey(mycurrent.getDay())){
               subjects_times.get(mycurrent.getSubject()).put(mycurrent.getDay(),new HashMap());
           }
           if(!subjects_times.get(mycurrent.getSubject()).get(mycurrent.getDay()).containsKey(mycurrent.getStart_time())){

               subjects_times.get(mycurrent.getSubject()).get(mycurrent.getDay()).put(mycurrent.getStart_time(),1);

           }
           else {
               subjects_times.get(mycurrent.getSubject()).get(mycurrent.getDay()).put(mycurrent.getStart_time(),(subjects_times.get(mycurrent.getSubject()).get(mycurrent.getDay()).get(mycurrent.getStart_time()))+1);

           }



           mycurrent = parent.get(mycurrent);
       }





       if(subjects_times!=null) {
           if (subjects_times.containsKey(new_to_add.getSubject())) {
               if (subjects_times.get(new_to_add.getSubject()).containsKey(new_to_add.getDay())) {
                   if (subjects_times.get(new_to_add.getSubject()).get(new_to_add.getDay()).containsKey(new_to_add.getStart_time())) {




                       if (subjects_times.get(new_to_add.getSubject()).get(new_to_add.getDay()).get(new_to_add.getStart_time()) >= students_number_in_lacture) {

                           return null;


                       }
                   }
               }
           }
       }













       ////////////////////////////////////////////////
       //////same student // same time of lecture
       ///////////////////////////////////////////////


        mycurrent=father;

       while (mycurrent != null) {

           if(mycurrent.getStudent_number()==0){
               mycurrent = parent.get(mycurrent);
               continue;}

           if(mycurrent.getStudent_number()==new_to_add.getStudent_number()){
               if(mycurrent.getDay()==new_to_add.getDay()){
                   if(mycurrent.getStart_time()==new_to_add.getStart_time()){
                       return null;
                   }
               }
           }

           mycurrent = parent.get(mycurrent);

       }







       //////////////////////////////////
       //////////make new state
       //////////////////////////////////

       new_one.add_on_table(new_to_add.getSubject(),new_to_add);

       mycurrent=father;

       graph_node father_current = parent.get(mycurrent);
       while (mycurrent != null) {

           if(mycurrent.getStudent_number()==0){
               mycurrent = parent.get(mycurrent);
               continue;}

           father_current = parent.get(mycurrent);

           new_one.add_on_table(mycurrent.getSubject(),mycurrent);



           if(father_current!=null && getweights(father_current,mycurrent,parent)==0){
               new_one.add_on_final_cost("to add student : namber : "+ mycurrent.getStudent_number() +" ,to subject : "+mycurrent.getSubject() +" , in day : "+mycurrent.getDay()+" , at : "+mycurrent.getStart_time() +" ,he prafers this day , it cost :"+(0));

           }
           else
           if(father_current!=null && getweights(father_current,mycurrent,parent)==200){
               new_one.add_on_final_cost("to add student : namber : "+ mycurrent.getStudent_number() +" ,to subject : "+mycurrent.getSubject() +" , in day : "+mycurrent.getDay()+" , at : "+mycurrent.getStart_time() +" ,he doesn't prafer this day , it cost :"+(200));

           }
           else
           if(father_current!=null && getweights(father_current,mycurrent,parent)==300){
               new_one.add_on_final_cost("to add student : namber : "+ mycurrent.getStudent_number() +" ,to subject : "+mycurrent.getSubject() +" , in day : "+mycurrent.getDay()+" , at : "+mycurrent.getStart_time() +" ,he has more than 3 lecture , it cost :"+(300));

           }
           else
           if(father_current!=null && getweights(father_current,mycurrent,parent)==400){
               new_one.add_on_final_cost("to add student : namber : "+ mycurrent.getStudent_number() +" ,to subject : "+mycurrent.getSubject() +" , in day : "+mycurrent.getDay()+" , at : "+mycurrent.getStart_time() +" ,he doesn't prafer this day and has more than 3 lecture , it cost :"+(400));

           }


           mycurrent = parent.get(mycurrent);
       }


       return new_one;

    }









    public float getweights(graph_node current,graph_node child,Map<graph_node,graph_node> parent){
       float cost=100;








        List<student_day> day_cant_come=mydata.day_cant_come();

        List<student_times> times_not_prefer=mydata.times_not_prefer();

        List<student_times> times_prefer=mydata.times_prefer();





                for(student_day s :day_cant_come){

                    if(s.getStudent_number()==child.getStudent_number() && s.getDay()==child.getDay()){

                        return 1000;
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




         ////////////////////////////////////
        ///////////// if studant have >3 lec
        ///////////////////////////////////

        List<Integer> student_in_day=new ArrayList<>(); //day /// lec number

                graph_node mycurrent=current;
                while (mycurrent!=null)
                {

                    if(mycurrent.getStudent_number()==child.getStudent_number() && mycurrent.getDay()==child.getDay()) {


                        if(!student_in_day.isEmpty()){
                            student_in_day.add(1);

                        }
                        else {
                            student_in_day.add(student_in_day.size() + 1);
                        }
                        }



                    mycurrent=parent.get(mycurrent);
                }

                if(student_in_day.size()>=2){
                    cost+=200;
                }










       return cost;
    }


}
