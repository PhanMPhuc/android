package com.example.recycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements androidVersionAdapter.ItemClicked {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<androidVersion> people;
    Button btadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        people = new ArrayList<>();

        // 🎵 Danh sách album của Taylor Swift
        people.add(new androidVersion("Taylor Swift", "2006", "taylorswift"));
        people.add(new androidVersion("Fearless", "2008", "fearlessalbum"));
        people.add(new androidVersion("Speak Now", "2010", "speaknowalbum"));
        people.add(new androidVersion("Red", "2012", "redalbum"));
        people.add(new androidVersion("1989", "2014", "nycalbum"));
        people.add(new androidVersion("Reputation", "2017", "reputationalbum"));
        people.add(new androidVersion("Lover", "2019", "lover"));
        people.add(new androidVersion("Folklore", "2020", "folklore"));
        people.add(new androidVersion("Evermore", "2020", "evermore"));
        people.add(new androidVersion("Midnights", "2022", "midnight"));
        people.add(new androidVersion("The Tortured Poets Department", "2024", "ttpd"));

        recyclerView = findViewById(R.id.ListR);
        btadd = findViewById(R.id.btadd);

        btadd.setOnClickListener(view -> {
            // 🎶 Thêm album mới
            people.add(new androidVersion("New Album", "2025", "new_album"));
            int newPosition = people.size() - 1;
            myAdapter.notifyItemInserted(newPosition);
            recyclerView.scrollToPosition(newPosition);
        });

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new androidVersionAdapter(this, people);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onItemClicked(int index) {
        Toast.makeText(this,
                "Album: " + people.get(index).getName() +
                        "\nNăm phát hành: " + people.get(index).getVersion(),
                Toast.LENGTH_LONG).show();
    }
}
