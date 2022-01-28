package com.example.myapplication;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskListViewAdapter extends RecyclerView.Adapter<TaskListViewAdapter.ViewHolder> {

    private ArrayList<Task> tasks;
    private LayoutInflater taskInflater;

    TaskListViewAdapter(Context context, ArrayList<Task> tasks) {
        this.taskInflater = LayoutInflater.from(context);
        this.tasks = tasks;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskListViewAdapter.ViewHolder holder, int position) {
        Task task = tasks.get(position);
        holder.taskName.setText(task.getName());
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    @NonNull
    @Override
    public TaskListViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = taskInflater.inflate(R.layout.tasklist_row, parent, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView taskName;
        ViewHolder(View itemView) {
            super(itemView);
            taskName = itemView.findViewById(R.id.taskName);
        }
    }
}
