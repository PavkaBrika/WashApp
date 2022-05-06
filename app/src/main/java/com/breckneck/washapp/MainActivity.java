package com.breckneck.washapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Room> roomsList = new ArrayList<Room>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.roomlist);
        RoomAdapter adapter = new RoomAdapter(this, roomsList);
        recyclerView.setAdapter(adapter);
    }

    private void setInitialData() {
        roomsList.add(new Room("Hello"));
        roomsList.add(new Room("worl"));
        roomsList.add(new Room("d"));
        roomsList.add(new Room("Hel123lo"));
    }
}