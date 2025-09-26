package com.example.tuan5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Tìm 2 nút trong layout
        Button btnA = findViewById(R.id.btn_screen_a);
        Button btnB = findViewById(R.id.btn_screen_b);

        // Gán sự kiện click cho nút A
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScreenAActivity.class);
                startActivity(intent);
            }
        });

        // Gán sự kiện click cho nút B
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScreenBActivity.class);
                startActivity(intent);
            }
        });
    }
}
