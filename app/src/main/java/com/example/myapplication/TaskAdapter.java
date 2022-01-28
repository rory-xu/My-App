package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    private ArrayList<Task> taskList;

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        public TextView totalTime;
        public TextView taskName;
        public Button timer;
        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            totalTime = itemView.findViewById(R.id.timer);
            taskName = itemView.findViewById(R.id.taskName);
            timer = itemView.findViewById(R.id.start);
        }
    }

    public TaskAdapter(ArrayList<Task> list) {
        taskList = list;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.task, parent, false);
        TaskViewHolder vh = new TaskViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task currentTask = taskList.get(position);

        holder.totalTime.setText(currentTask.getTimer());
        holder.taskName.setText(currentTask.getName());
        holder.timer.setText("start");
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
}
