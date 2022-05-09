package com.breckneck.washapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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
    String name;
    List<Zone> zonesList = new ArrayList<Zone>();

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

        ZoneAdapter.OnZoneClickListener zoneClickListener = new ZoneAdapter.OnZoneClickListener() {
            @Override
            public void onZoneClick(Zone zone, int position) {
                Intent intent = new Intent();
                Toast.makeText(getApplicationContext(), ",был выбран элемент" + zone.getZoneName() + "  " + zone.getId(), Toast.LENGTH_SHORT).show();

            }
        };

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                db = Room.databaseBuilder(getApplicationContext(), AppDataBaseZone.class, "ZoneDataBase").build();
                zoneDao = db.zoneDao();
                zonesList = db.zoneDao().getAll();
                RecyclerView recyclerView = findViewById(R.id.zonelist);
                ZoneAdapter adapter = new ZoneAdapter(getApplicationContext(), zonesList, zoneClickListener);
                recyclerView.setAdapter(adapter);
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