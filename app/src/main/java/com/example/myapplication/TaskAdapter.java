package com.example.myapplication;

import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ItemTouchHelper;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> implements TaskTouchHelperAdapter{
    private ArrayList<Task> taskList;
    private ItemTouchHelper taskTouchHelper;


    @Override
    public void onTaskMove(int from, int to) {
        Task fromTask = taskList.get(from);
        taskList.remove(fromTask);
        taskList.add(to, fromTask);

    }

    @Override
    public void onTaskSwiped(int position) {
        taskList.remove(position);
    }

    public void setTouchHelper(ItemTouchHelper touchHelper) {
        this.taskTouchHelper = touchHelper;
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder implements
            View.OnTouchListener,
            GestureDetector.OnGestureListener {
        public TextView totalTime;
        public TextView taskName;
        public Button timer;
        GestureDetector taskGestureDetector;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            totalTime = itemView.findViewById(R.id.timer);
            taskName = itemView.findViewById(R.id.taskName);
            timer = itemView.findViewById(R.id.start);

            taskGestureDetector = new GestureDetector(itemView.getContext(), this);

            itemView.setOnTouchListener(this);
        }

        @Override
        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        @Override
        public void onShowPress(MotionEvent motionEvent) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            return false;
        }

        @Override
        public void onLongPress(MotionEvent motionEvent) {
            taskTouchHelper.startDrag(this);
        }

        @Override
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            return false;
        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            taskGestureDetector.onTouchEvent(motionEvent);
            return true;
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
