package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TaskActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Task> taskList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_task);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Примеры заданий (в реальности — из API/БД)
        taskList.add(new Task("TASK-2024-001", "BATCH-2024-0001", "Растаривание", "Назначено", "Высокий", "ПГ-001", "Распаковать мешки с ПЭТ"));
        taskList.add(new Task("TASK-2024-007", "BATCH-2024-0002", "Очистка", "Назначено", "Высокий", "ОЧ-002", "Запустить горячую очистку"));

        TaskAdapter adapter = new TaskAdapter(taskList, this);
        recyclerView.setAdapter(adapter);
    }
}