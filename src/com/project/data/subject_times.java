package com.project.data;

public class subject_times {
    int subject ;
    int day;
    int start_time;

    boolean is_practical;

    public subject_times(int subject, int day, int start_time, boolean is_practical) {
        this.subject = subject;
        this.day = day;
        this.start_time = start_time;
        this.is_practical=is_practical;
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

    public boolean getis_practical() {
        return is_practical;
    }
}
