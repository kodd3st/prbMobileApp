package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerUsers;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
        spinnerUsers = findViewById(R.id.spinnerUsers);
        btnLogin = findViewById(R.id.btnLogin);
        List<User> users = Arrays.asList(
                new User("USER-001", "Иванов А.С. (Оператор)", "OPERATOR"),
                new User("USER-005", "Козлов М.О. (Оператор)", "OPERATOR"),
                new User("USER-009", "Попова О.В. (Оператор)", "OPERATOR")
        );
        ArrayAdapter<User> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, users);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUsers.setAdapter(adapter);

        btnLogin.setOnClickListener(v -> {
            User selected = (User) spinnerUsers.getSelectedItem();
            Intent intent = new Intent(MainActivity.this, TaskActivity.class);
            intent.putExtra("USER_ID", selected.getUserId());
            startActivity(intent);
            finish();
        });
    }
}