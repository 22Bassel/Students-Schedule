package com.project.state;

import java.util.ArrayList;
import java.util.List;

public class one_state {
    int subject;
    int day;
    int start_time;
    List<Integer> student_numbers;

    public one_state() {
        this.student_numbers = new ArrayList<>();
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public void setStudent_numbers(List<Integer> student_numbers) {
        this.student_numbers = student_numbers;
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

    public List<Integer> getStudent_numbers() {
        return student_numbers;
    }

    public void add_student(int id){

        student_numbers.add(id);
    }
}
