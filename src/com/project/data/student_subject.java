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
public class student_subject {
    
     int student_number;
    int subject_number;
   
     public student_subject(int student_number, int subject_number) {
        this.student_number = student_number;
        this.subject_number=subject_number;
    }

    public int getStudent_number() {
        return student_number;
    }

    public int getSubject_number() {
        return subject_number;
    }
}
