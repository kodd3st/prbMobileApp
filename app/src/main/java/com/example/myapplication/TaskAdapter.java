package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    private List<Task> tasks;
    private Context context;

    public TaskAdapter(List<Task> tasks, Context context) {
        this.tasks = tasks;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Task task = tasks.get(position);
        holder.textBatch.setText(task.getBatchId());
        holder.textStage.setText(task.getStage());
        holder.textInstructions.setText(task.getInstructions());

        holder.buttonStart.setOnClickListener(v -> {
            Intent intent = new Intent(context, StartStageActivity.class);
            intent.putExtra("TASK", task.getTaskId());
            intent.putExtra("BATCH", task.getBatchId());
            intent.putExtra("STAGE", task.getStage());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textBatch, textStage, textInstructions;
        Button buttonStart;

        ViewHolder(View itemView) {
            super(itemView);
            textBatch = itemView.findViewById(R.id.textBatch);
            textStage = itemView.findViewById(R.id.textStage);
            textInstructions = itemView.findViewById(R.id.textInstructions);
            buttonStart = itemView.findViewById(R.id.buttonStart);
        }
    }
}
