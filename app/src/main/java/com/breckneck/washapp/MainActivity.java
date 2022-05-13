package com.breckneck.washapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences AppSettings;

    public static final String APP_PREFERENCES = "settings";
    public static final String ZONE = "zone";
    public static final String ZONES = "zones";

    ZoneDao zoneDao;
    AppDataBaseZone db;
    Button addNewZone;
    boolean hasVisited;
    String name;
    List<Zone> zonesList = new ArrayList<Zone>();

    ZoneAdapter.OnZoneClickListener zoneClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        addNewZone = findViewById(R.id.addNewZoneButton);
        addNewZone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddNewZoneActivity.class);
                startActivity(intent);
            }
        });

        zoneClickListener = new ZoneAdapter.OnZoneClickListener() {
            @Override
            public void onZoneClick(Zone zone, int position) {
                if (zone.getId() == 999) {
                    Intent intent = new Intent(MainActivity.this, AddNewZoneActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(MainActivity.this, ZoneDetails.class);
                    intent.putExtra("zoneid", zone.getId());
                    Toast.makeText(getApplicationContext(), ",был выбран элемент" + zone.getZoneName() + "  " + zone.getId(), Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                hasVisited = AppSettings.getBoolean("hasVisited", false);
                db = Room.databaseBuilder(getApplicationContext(), AppDataBaseZone.class, "ZoneDataBase").build();
                zoneDao = db.zoneDao();
                if (!hasVisited) {
                    Zone zone = new Zone();
                    zone.id = 999;
                    zone.zoneName = "";
                    zone.setPicture(R.drawable.ic_outline_add_circle_outline_24);
                    zoneDao.insert(zone);
                    SharedPreferences.Editor editor = AppSettings.edit();
                    editor.putBoolean("hasVisited", true);
                    editor.apply();
                }
                zonesList = db.zoneDao().getAll();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        RecyclerView recyclerView = findViewById(R.id.zonelist);
                        ZoneAdapter adapter = new ZoneAdapter(getApplicationContext(), zonesList, zoneClickListener);
                        recyclerView.setAdapter(adapter);
                    }
                });
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

    }
}