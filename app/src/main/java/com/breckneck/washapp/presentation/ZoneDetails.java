package com.breckneck.washapp.presentation;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.breckneck.washapp.adapter.TaskAdapter;
import com.breckneck.washapp.presentation.AddNewTaskActivity;

import java.util.ArrayList;
import java.util.List;

public class ZoneDetails extends AppCompatActivity {

//    private SharedPreferences ZoneDetaisSP;
//
//    public static final String ZoneDetailsSP = "settings";
//
//    long id;
//    String title;
//    Task task;
//    Zone zone;
//    AppDataBaseZone db;
//    ZoneDao zoneDao;
//    Button button;
//    boolean hasVisited;
//    List<Task> tasksList = new ArrayList<>();
//
//    TaskAdapter.OnTaskClickListener taskClickListener;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_zonedetails);
//
//        ZoneDetaisSP = getSharedPreferences(ZoneDetailsSP, Context.MODE_PRIVATE);
//
//        button = findViewById(R.id.addNewTaskButton);
//
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        Bundle arguments = getIntent().getExtras();
//        if (arguments != null) {
//            id = arguments.getLong("zoneid");
//        }
//
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                db = Room.databaseBuilder(getApplicationContext(), AppDataBaseZone.class, "ZoneDataBase").build();
//                zoneDao = db.zoneDao();
//                zone = db.zoneDao().getZoneById(id);
//                getSupportActionBar().setTitle(zone.getZoneName() + " " + getString(R.string.tasks));
//            }
//        };
//        Thread thread = new Thread(runnable);
//        thread.start();
//
//        taskClickListener = new TaskAdapter.OnTaskClickListener() {
//            @Override
//            public void onTaskClick(Task task, int position) {
//                Intent intent = new Intent(ZoneDetails.this, TaskDetails.class);
//                startActivity(intent);
//            }
//        };
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ZoneDetails.this, AddNewTaskActivity.class);
//                intent.putExtra("zoneid", id);
//                startActivity(intent);
//            }
//        });
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                db = Room.databaseBuilder(getApplicationContext(), AppDataBaseZone.class, "ZoneDataBase").build();
//                zoneDao = db.zoneDao();
//                tasksList = db.zoneDao().getTasksByZoneId(id);
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        RecyclerView recyclerView = findViewById(R.id.tasklist);
//                        TaskAdapter adapter = new TaskAdapter(getApplicationContext(), tasksList, taskClickListener);
//                        recyclerView.setAdapter(adapter);
//                    }
//                });
//            }
//        };
//        Thread thread = new Thread(runnable);
//        thread.start();
//
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        super.onCreateOptionsMenu(menu);
//       // menu.add(R.string.deletezone).setIcon(R.drawable.ic_launcher_foreground);
//        getMenuInflater().inflate(R.menu.menu_activity_zonedetails, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
////        String title = item.getTitle().toString();
////        String string = getString(R.string.deletezone);
//        int id = item.getItemId();
////        if (title.equals(string)) {
//        switch (item.getItemId()) {
//            case R.id.delete_button:
//                AlertDialog.Builder builder = new AlertDialog.Builder(ZoneDetails.this);
//                builder.setTitle(R.string.deletezone);
//                builder.setMessage(R.string.alertdialogdeletebutton);
//                builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Runnable runnable = new Runnable() {
//                            @Override
//                            public void run() {
//                                db.zoneDao().deleteZone(zone);
//                                finish();
//                            }
//                        };
//                        Thread thread = new Thread(runnable);
//                        thread.start();
//                    }
//                });
//                builder.setNegativeButton(R.string.no, null);
//                builder.show();
//                return true;
//            case android.R.id.home:
//                super.onBackPressed();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
