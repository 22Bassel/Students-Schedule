package com.project.graph;

import com.project.state.one_state;

import java.util.HashSet;
import java.util.Set;

public class graph_node {

    private final int id;
    private final Set<graph_node> children= new HashSet<>();
    private final int subject;
    private final int day;
    private final  int start_time;
    private final int student_number;
    private final boolean is_practical;
    //private final int lecture_number;


    public graph_node(int id, int subject, int day, int start_time,int student_number,boolean is_practical) {
        this.id = id;
        this.subject = subject;
        this.day = day;
        this.start_time = start_time;
        this.student_number=student_number;
        this.is_practical=is_practical;
        //this.lecture_number=lecture_number;
    }

    public void addchild(graph_node child){
        children.add(child);
    }
    public Set<graph_node> getChildren(){
        return children;
    }

    public int getId(){
        return id;
    }

    public int getSubject() {
        return subject;
    }

    public int getDay() {
        return day;
    }

    public int getStart_time() {
        return start_time;
    }

    public int getStudent_number() {
        return student_number;
    }

    public boolean isIs_practical() {
        return is_practical;
    }

    //
//    public int getLecture_number() {
//        return lecture_number;
//    }

    //////////////////
    ////override
    //////////////////

    @Override
    public boolean equals(Object myobject){
        if(myobject==null || !getClass().equals(myobject.getClass())){
            return false;
        }

        int o_id=((graph_node)myobject).getId();

        if(o_id == id)
        { return true;}
        else
            {return false;}

    }

    @Override
    public String toString(){
        return "\n node id is "+id  +
                "        subject "+ subject +
                "        day "+ day+
                "        start_time "+ start_time +
                "        student_number "+student_number +
                "         is_practical "+is_practical;
    }
}
