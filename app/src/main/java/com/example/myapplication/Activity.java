package com.example.myapplication;

import java.util.Calendar;

public class Activity {
    private Calendar startTime;
    private Calendar endTime;


    public Activity(Calendar startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }
}
