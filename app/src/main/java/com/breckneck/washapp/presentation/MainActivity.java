package com.breckneck.washapp.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.breckneck.washapp.AppDataBaseZone;
import com.breckneck.washapp.R;
import com.breckneck.washapp.Zone;
import com.breckneck.washapp.ZoneDao;
import com.breckneck.washapp.ZoneDetails;
import com.breckneck.washapp.adapter.ZoneAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences AppSettings;

    public static final String APP_PREFERENCES = "settings";

    ZoneDao zoneDao;
    AppDataBaseZone db;
    boolean hasVisited;
    String name;
    List<Zone> zonesList = new ArrayList<Zone>();

    ZoneAdapter.OnZoneClickListener zoneClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

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
                    zoneDao.insertZone(zone);
                    SharedPreferences.Editor editor = AppSettings.edit();
                    editor.putBoolean("hasVisited", true);
                    editor.apply();
                }
                zonesList = db.zoneDao().getAllZones();
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