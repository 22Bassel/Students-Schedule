/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.data;

/**
 *
 * @author TOSHIBA
 */
public class student_day {
     int student_number;
        int day;
   
     public student_day(int student_number, int day) {
        this.student_number = student_number;
        this.day=day;
    }

    public int getStudent_number() {
        return student_number;
    }

    public int getDay() {
        return day;
    }
}
