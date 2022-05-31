package com.breckneck.washapp.presentation;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.breckneck.washapp.AppDataBaseZone;
import com.breckneck.washapp.R;
import com.breckneck.washapp.model.Task;
import com.breckneck.washapp.ZoneDao;

public class AddNewTaskActivity extends AppCompatActivity {

//    String name;
//    long idzone;
//    long idtask;
//    SharedPreferences Taskid;
//
//    public final String TASK_ID = "taskid";
//    public final String ID = "id";
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_addnewtask);
//
//        Taskid = getSharedPreferences(TASK_ID, Context.MODE_PRIVATE);
//        idtask =  0;
//
//        EditText addNewTask = findViewById(R.id.edittext);
//        Button button = findViewById(R.id.button);
//
//        Bundle arguments = getIntent().getExtras();
//        if (arguments != null) {
//            idzone = arguments.getLong("zoneid");
//        }
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Runnable runnable = new Runnable() {
//                    @Override
//                    public void run() {
//                        name = addNewTask.getText().toString();
//                        AppDataBaseZone db = Room.databaseBuilder(getApplicationContext(), AppDataBaseZone.class, "ZoneDataBase").build();
//                        ZoneDao zoneDao = db.zoneDao();
//                        Task task = new Task();
//                        task.id = idtask;
//                        task.zoneId = idzone;
//                        task.taskName = name;
//                        zoneDao.insertTask(task);
//                    }
//                };
//                Thread thread = new Thread(runnable);
//                thread.start();
//                idtask++;
//                SharedPreferences.Editor editor = Taskid.edit();
//                editor.putLong(ID, idtask);
//                editor.apply();
//                finish();
//            }
//        });
//
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        if (Taskid.contains(ID)) {
//            idtask = Taskid.getLong(ID, 0);
//        }
//    }
}
