package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TaskListViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Task> activeTasks = new ArrayList<>();
        activeTasks.add(new Task("Task 1"));

        RecyclerView recyclerView = findViewById(R.id.taskList);
        adapter = new TaskListViewAdapter(this, activeTasks);
        recyclerView.setAdapter(adapter);
    }

}