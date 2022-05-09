package com.breckneck.washapp;

import android.app.ActionBar;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class ZoneDetails extends AppCompatActivity {

    long id;
    String title;
    Zone zone;
    AppDataBaseZone db;
    ZoneDao zoneDao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zonedetails);

        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            id = arguments.getLong("zoneid");
        }

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                db = Room.databaseBuilder(getApplicationContext(), AppDataBaseZone.class, "ZoneDataBase").build();
                zoneDao = db.zoneDao();
                zone = db.zoneDao().getById(id);
                getSupportActionBar().setTitle(zone.getZoneName());
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();


    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
