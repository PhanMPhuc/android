package com.example.kiemtragiuaki;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.kiemtragiuaki.model.Book;

public class DisplayBookActivity extends AppCompatActivity {
    TextView txtTitle, txtAuthor, txtYear;
    Button btnReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_display_book);
        txtTitle = findViewById(R.id.txtTitle);
        txtAuthor = findViewById(R.id.txtAuthor);
        txtYear = findViewById(R.id.txtYear);
        btnReturn = findViewById(R.id.btnReturn);
        Intent intent = getIntent();
        Book book = (Book)intent.getSerializableExtra("BookData");
            if(book != null){
                txtTitle.setText(book.getTitle());
                txtAuthor.setText(book.getAuthor());
                txtYear.setText(String.valueOf(book.getYear()));
            }
            btnReturn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1 = new Intent(DisplayBookActivity.this, InputSachActivity.class);
                    startActivity(intent1);
                }
            });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}