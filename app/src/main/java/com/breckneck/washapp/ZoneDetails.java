package com.breckneck.washapp;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
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

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
       // menu.add(R.string.deletezone).setIcon(R.drawable.ic_launcher_foreground);
        getMenuInflater().inflate(R.menu.menu_activity_zonedetails, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        String title = item.getTitle().toString();
//        String string = getString(R.string.deletezone);
        int id = item.getItemId();
//        if (title.equals(string)) {
        switch (item.getItemId()) {
            case R.id.delete_button:
                AlertDialog.Builder builder = new AlertDialog.Builder(ZoneDetails.this);
                builder.setTitle(R.string.deletezone);
                builder.setMessage(R.string.alertdialogdeletebutton);
                builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Runnable runnable = new Runnable() {
                            @Override
                            public void run() {
                                db.zoneDao().delete(zone);
                                finish();
                            }
                        };
                        Thread thread = new Thread(runnable);
                        thread.start();
                    }
                });
                builder.setNegativeButton(R.string.no, null);
                builder.show();
                return true;
            case android.R.id.home:
                super.onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
