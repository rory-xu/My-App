package com.example.myapplication;

import java.util.ArrayList;

public class Task {
    private String name;
    private String timer;
    private ArrayList<Activity> activities;

    public Task(String name) {
        this.name = name;
        this.timer = "0h0m";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimer() {
        return timer;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }


}
