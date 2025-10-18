package com.example.kiemtragiuaki;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.kiemtragiuaki.model.Book;

public class InputSachActivity extends AppCompatActivity {
    EditText edtSach, edtTacGia, edtNam;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.input_sach_activity);
        edtSach = findViewById(R.id.edtSach);
        edtTacGia = findViewById(R.id.edtTacGia);
        edtNam = findViewById(R.id.edtNam);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener( v -> {
            String Sach = edtSach.getText().toString();
            String TacGia = edtTacGia.getText().toString();
            int Nam = Integer.parseInt(edtNam.getText().toString());
            Book book = new Book(Sach, TacGia, Nam);;
            Intent intent = new Intent(InputSachActivity.this, DisplayBookActivity.class);
            intent.putExtra("BookData",book);
            startActivity(intent);

        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}