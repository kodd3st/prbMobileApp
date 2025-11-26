package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QualityCheckActivity extends AppCompatActivity {

    private EditText editWidth, editWaste;
    private String batchId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quality_check);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
        batchId = getIntent().getStringExtra("BATCH");
        TextView textBatch = findViewById(R.id.textBatch);
        editWidth = findViewById(R.id.editWidth);
        editWaste = findViewById(R.id.editWaste);
        Button btnTakePhoto = findViewById(R.id.btnTakePhoto);
        Button btnSubmit = findViewById(R.id.btnSubmit);

        textBatch.setText("Партия: " + batchId);

        btnTakePhoto.setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intent, 100);
            }
        });

        btnSubmit.setOnClickListener(v -> {
            if (!editWidth.getText().toString().isEmpty() && !editWaste.getText().toString().isEmpty()) {
                // Отправка в БД (эмуляция)
                Toast.makeText(this, "Данные отправлены", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            Toast.makeText(this, "Фото сохранено", Toast.LENGTH_SHORT).show();
        }
    }
}