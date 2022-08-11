/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public class data {
 
    int students_number_in_lacture=5;
    int subject_number=5;    // عدد المقرارات الطلي





    public int getStudents_number_in_lacture() {
        return students_number_in_lacture;
    }

    public int getSubject_number() {
        return subject_number;
    }










    public List<student_times> times_prefer(){
        
        return  Arrays.asList(
                new student_times(1,1,10),
                new student_times(1,2,12),
                new student_times(1,3,8),
                new student_times(1,4,10),
                new student_times(1,5,12),
                
                new student_times(2,1,14),
                new student_times(2,2,8),
                new student_times(2,3,10),
                new student_times(2,4,12),
                new student_times(2,5,8),
                
                
                new student_times(3,1,10),
                new student_times(3,2,12),
                new student_times(3,3,8),
                new student_times(3,4,10),
                new student_times(3,5,12),

                
                new student_times(4,1,10),
                new student_times(4,2,12),
                new student_times(4,3,8),
                new student_times(4,4,10),
                new student_times(4,5,12),
                
                new student_times(5,1,14),
                new student_times(5,2,8),
                new student_times(5,3,10),
                new student_times(5,4,12),
                new student_times(5,5,8),
                
                
                new student_times(6,1,10),
                new student_times(6,2,12),
                new student_times(6,3,8),
                new student_times(6,4,10),
                new student_times(6,5,12),
                
                new student_times(7,1,14),
                new student_times(7,2,8),
                new student_times(7,3,10),
                new student_times(7,4,12),
                new student_times(7,5,8),
                
                
                new student_times(8,1,10),
                new student_times(8,2,12),
                new student_times(8,3,8),
                new student_times(8,4,10),
                new student_times(8,5,12),
                
                new student_times(9,1,14),
                new student_times(9,2,8),
                new student_times(9,3,10),
                new student_times(9,4,12),
                new student_times(9,5,8),
                
                
                new student_times(10,1,10),
                new student_times(10,2,12),
                new student_times(10,3,8),
                new student_times(10,4,10),
                new student_times(10,5,12),
                
                new student_times(11,1,14),
                new student_times(11,2,8),
                new student_times(11,3,10),
                new student_times(11,4,12),
                new student_times(11,5,8),
                
                
                new student_times(12,1,10),
                new student_times(12,2,12),
                new student_times(12,3,8),
                new student_times(12,4,10),
                new student_times(12,5,12),
                
                new student_times(13,1,14),
                new student_times(13,2,8),
                new student_times(13,3,10),
                new student_times(13,4,12),
                new student_times(13,5,8),
                
                
                new student_times(14,1,10),
                new student_times(14,2,12),
                new student_times(14,3,8),
                new student_times(14,4,10),
                new student_times(14,5,12),
                
                new student_times(15,1,14),
                new student_times(15,2,8),
                new student_times(15,3,10),
                new student_times(15,4,12),
                new student_times(15,5,8),
                
                
                new student_times(16,1,10),
                new student_times(16,2,12),
                new student_times(16,3,8),
                new student_times(16,4,10),
                new student_times(16,5,12),
                
                new student_times(17,1,14),
                new student_times(17,2,8),
                new student_times(17,3,10),
                new student_times(17,4,12),
                new student_times(17,5,8),
                
                
                new student_times(18,1,10),
                new student_times(18,2,12),
                new student_times(18,3,8),
                new student_times(18,4,10),
                new student_times(18,5,12),
                
                new student_times(19,1,10),
                new student_times(19,2,12),
                new student_times(19,3,8),
                new student_times(19,4,10),
                new student_times(19,5,12),
                
                new student_times(20,1,14),
                new student_times(20,2,8),
                new student_times(20,3,10),
                new student_times(20,4,12),
                new student_times(20,5,8)
                
        );
    }

    
    
    
    
    
    public List<student_times> times_not_prefer(){
        
        return  Arrays.asList(
                new student_times(1,1,8),
                new student_times(1,2,10),
                new student_times(1,3,14),
                new student_times(1,4,8),
                new student_times(1,5,10),
                
                new student_times(2,1,12),
                new student_times(2,2,14),
                new student_times(2,3,8),
                new student_times(2,4,10),
                new student_times(2,5,14),
                
                
                new student_times(3,1,12),
                new student_times(3,2,14),
                new student_times(3,3,10),
                new student_times(3,4,12),
                new student_times(3,5,14),
                
                
                
                new student_times(4,1,12),
                new student_times(4,2,14),
                new student_times(4,3,10),
                new student_times(4,4,12),
                new student_times(4,5,14),
                
                new student_times(5,1,10),
                new student_times(5,2,12),
                new student_times(5,3,14),
                new student_times(5,4,8),
                new student_times(5,5,12),
                
                
                new student_times(6,1,10),
                new student_times(6,2,8),
                new student_times(6,3,10),
                new student_times(6,4,12),
                new student_times(6,5,10),
                
                new student_times(7,1,8),
                new student_times(7,2,10),
                new student_times(7,3,12),
                new student_times(7,4,10),
                new student_times(7,5,14),
                
                
                new student_times(8,1,12),
                new student_times(8,2,10),
                new student_times(8,3,12),
                new student_times(8,4,12),
                new student_times(8,5,8),
                
                new student_times(9,1,8),
                new student_times(9,2,12),
                new student_times(9,3,14),
                new student_times(9,4,14),
                new student_times(9,5,10),
                
                
                new student_times(10,1,8),
                new student_times(10,2,10),
                new student_times(10,3,14),
                new student_times(10,4,12),
                new student_times(10,5,8),
                
                new student_times(11,1,12),
                new student_times(11,2,8),
                new student_times(11,3,14),
                new student_times(11,4,14),
                new student_times(11,5,10),
                
                
                new student_times(12,1,12),
                new student_times(12,2,8),
                new student_times(12,3,12),
                new student_times(12,4,14),
                new student_times(12,5,14),
                
                new student_times(13,1,12),
                new student_times(13,2,12),
                new student_times(13,3,8),
                new student_times(13,4,10),
                new student_times(13,5,10),
                
                
                new student_times(14,1,12),
                new student_times(14,2,8),
                new student_times(14,3,12),
                new student_times(14,4,12),
                new student_times(14,5,14),
                
                new student_times(15,1,12),
                new student_times(15,2,14),
                new student_times(15,3,12),
                new student_times(15,4,14),
                new student_times(15,5,10),
                
                
                new student_times(16,1,12),
                new student_times(16,2,8),
                new student_times(16,3,12),
                new student_times(16,4,14),
                new student_times(16,5,14),
                
                new student_times(17,1,10),
                new student_times(17,2,12),
                new student_times(17,3,8),
                new student_times(17,4,10),
                new student_times(17,5,14),
                
                
                new student_times(18,1,8),
                new student_times(18,2,14),
                new student_times(18,3,14),
                new student_times(18,4,12),
                new student_times(18,5,8),
                
                new student_times(19,1,8),
                new student_times(19,2,14),
                new student_times(19,3,10),
                new student_times(19,4,14),
                new student_times(19,5,8),
                
                new student_times(20,1,8),
                new student_times(20,2,10),
                new student_times(20,3,14),
                new student_times(20,4,14),
                new student_times(20,5,14)
                
        );
    }
    
    
    
    
    public static List<student_subject> subject(){
        
        return  Arrays.asList(
        
                
                new student_subject(1,1),
                new student_subject(1,3),
                new student_subject(1,4),
                new student_subject(1,5),
                
                new student_subject(2,1),
                new student_subject(2,4),
                new student_subject(2,5),
                
                
                new student_subject(3,1),
                new student_subject(3,2),
                new student_subject(3,3),
                new student_subject(3,4),

                
                new student_subject(4,1),
                new student_subject(4,3),
                new student_subject(4,4),
                new student_subject(4,5),
                
                new student_subject(5,1),
                new student_subject(5,2),
                new student_subject(5,3),

                
                new student_subject(6,2),
                new student_subject(6,3),
                new student_subject(6,4),

                new student_subject(7,1),
                new student_subject(7,2),
                new student_subject(7,3),

                
                new student_subject(8,1),
                new student_subject(8,2),
                new student_subject(8,4),
                new student_subject(8,5),
                
                new student_subject(9,4),
                new student_subject(9,5),
                
                
                new student_subject(10,1),
                new student_subject(10,2),
                new student_subject(10,3),
                new student_subject(10,5),
                
                
                new student_subject(11,3),
                new student_subject(11,4),
                new student_subject(11,5),
                
                new student_subject(12,1),
                new student_subject(12,5),
                

                new student_subject(13,1),
                new student_subject(13,3),
                new student_subject(13,5),
                
                
                new student_subject(14,1),
                new student_subject(14,3),
                new student_subject(14,5),
                
                new student_subject(15,2),
                new student_subject(15,4),
                new student_subject(15,5),
                
                
                new student_subject(16,1),
                new student_subject(16,4),
                new student_subject(16,5),
                
                new student_subject(17,2),
                new student_subject(17,3),
                new student_subject(17,4),

                
                new student_subject(18,3),
                new student_subject(18,4),
                new student_subject(18,5),
                
                new student_subject(19,1),
                new student_subject(19,3),
                
                
                
                new student_subject(20,1),
                new student_subject(20,2),
                new student_subject(20,5)
                
        );
        
        
    }
    
    
    
    public List<student_day> day_cant_come(){
        
        return  Arrays.asList(
        

                new student_day(1,1),

                new student_day(2,4),


                new student_day(3,5),
                

                new student_day(4,4),
                
                new student_day(5,1),
                //new student_day(5,2),

                new student_day(6,3),
                
                new student_day(7,4),
                //new student_day(7,5),

                
                new student_day(8,4),
                
                new student_day(9,4),
                
                new student_day(10,3),
                //new student_day(10,4),
                

                new student_day(11,2),
                //new student_day(11,5),
                
                new student_day(12,1),
                //new student_day(12,2),
                
                
                new student_day(13,2),


                
                new student_day(14,5),



                new student_day(15,1),
                //new student_day(15,4),
                
                
                new student_day(16,1),
                //new student_day(16,5),
                
                new student_day(17,1),

                new student_day(18,3),
                //new student_day(18,3),

                new student_day(19,1),
                //new student_day(19,2),


                //new student_day(20,1),
               new student_day(20,0)
        );
        
        
    }





    public List<subject_times> schedule(){

        return  Arrays.asList(


                /// 1
                new subject_times(1,5,8,false),
                new subject_times(1,3,10,false),
                new subject_times(1,5,12,false),


                new subject_times(1,2,8,true),
                new subject_times(1,2,12,true),
                new subject_times(1,4,10,true),


                ///// 2

                new subject_times(2,1,8,false),
                new subject_times(2,3,8,false),


                new subject_times(2,2,8,true),
                new subject_times(2,3,12,true),


                ////// 3
                new subject_times(3,1,10,false),
                new subject_times(3,5,8,false),
                new subject_times(3,3,14,false),


                new subject_times(3,2,10,true),
                new subject_times(3,3,8,true),
                new subject_times(3,4,12,true),

                /////// 4

                new subject_times(4,4,8,false),
                new subject_times(4,4,10,false),
                new subject_times(4,1,12,false),


                new subject_times(4,2,10,true),
                new subject_times(4,3,12,true),
                new subject_times(4,4,12,true),


                /////// 5

                new subject_times(5,1,14,false),
                new subject_times(5,5,10,false),
                new subject_times(5,5,14,false),


                new subject_times(5,2,14,true),
                new subject_times(5,3,10,true),
                new subject_times(5,4,14,true)
        );


    }









}
