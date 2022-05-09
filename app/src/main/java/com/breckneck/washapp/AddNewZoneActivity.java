package com.breckneck.washapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class AddNewZoneActivity extends AppCompatActivity {

    String name;
    long idzone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnewroom);

        EditText id = findViewById(R.id.id);
        EditText addNewZone = findViewById(R.id.addNewZoneEditText);
        Button ok = findViewById(R.id.okAddNewZoneButton);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = addNewZone.getText().toString();
                idzone =Long.parseLong(id.getText().toString());
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        AppDataBaseZone db = Room.databaseBuilder(getApplicationContext(), AppDataBaseZone.class, "ZoneDataBase").build();
                        ZoneDao zoneDao = db.zoneDao();
                        Zone zone = new Zone();
                        zone.id = idzone;
                        zone.zoneName = name;
                        zoneDao.insert(zone);
                    }
                };
                Thread thread = new Thread(runnable);
                thread.start();
                Intent intent = new Intent(AddNewZoneActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
