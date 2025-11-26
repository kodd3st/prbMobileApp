package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StartStageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_start_stage);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
        TextView textInfo = findViewById(R.id.textInfo);
        Button btnConfirm = findViewById(R.id.btnConfirm);

        String batch = getIntent().getStringExtra("BATCH");
        String stage = getIntent().getStringExtra("STAGE");
        textInfo.setText(batch + " — " + stage);

        btnConfirm.setOnClickListener(v -> {
            // Здесь: отправка в БД через API (эмуляция)
            Toast.makeText(this, "Этап «" + stage + "» начат", Toast.LENGTH_SHORT).show();

            if ("Очистка".equals(stage)) {
                Intent intent = new Intent(this, QualityCheckActivity.class);
                intent.putExtra("BATCH", batch);
                startActivity(intent);
            } else {
                finish();
            }
        });
    }
}