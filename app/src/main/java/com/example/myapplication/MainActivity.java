package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter TaskListViewAdapter;
    private RecyclerView.LayoutManager TaskListLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Task> activeTasks = new ArrayList<>();
        ArrayList<Task> archivedTasks = new ArrayList<>();
        activeTasks.add(new Task("Task 1"));
        activeTasks.add(new Task("Task 2"));
        activeTasks.add(new Task("Task 3"));


        recyclerView = findViewById(R.id.taskList);
        recyclerView.setHasFixedSize(true);
        TaskListLayoutManager = new LinearLayoutManager(this);
        TaskListViewAdapter = new TaskAdapter(activeTasks);

        recyclerView.setLayoutManager(TaskListLayoutManager);
        recyclerView.setAdapter(TaskListViewAdapter);

    }

}