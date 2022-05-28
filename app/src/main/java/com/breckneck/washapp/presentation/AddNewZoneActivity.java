package com.breckneck.washapp.presentation;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.breckneck.washapp.AppDataBaseZone;
import com.breckneck.washapp.R;
import com.breckneck.washapp.Zone;
import com.breckneck.washapp.ZoneDao;

public class AddNewZoneActivity extends AppCompatActivity {

    String name;
    long idzone;
    boolean myvariant = false;
    SharedPreferences ZoneId;

    public final String ZONE_ID = "zoneid";
    public final String ID = "id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnewzone);

        String[] zoneNames = {getString(R.string.livingroom), getString(R.string.Hallway), getString(R.string.Kitchen), getString(R.string.Bedroom), getString(R.string.Bathroom),
                getString(R.string.Toilet), getString(R.string.Childrensroom), getString(R.string.Bathroom), getString(R.string.Myversion)};

        View v = getWindow().getDecorView();
        v.setBackgroundResource(android.R.color.transparent);

        ZoneId = getSharedPreferences(ZONE_ID, MODE_PRIVATE);
        idzone = 0;

        EditText addNewZone = findViewById(R.id.addNewZoneEditText);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, zoneNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String item = (String) parent.getItemAtPosition(position);
                if (item.equals(getString(R.string.Myversion))) {
                    addNewZone.setVisibility(View.VISIBLE);
                    myvariant = true;
                }
                else {
                    addNewZone.setVisibility(View.GONE);
                    name = item;
                    myvariant = false;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);


        Button ok = findViewById(R.id.okAddNewZoneButton);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //name = addNewZone.getText().toString();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        if (myvariant) {
                            name = addNewZone.getText().toString();
                        }
                        AppDataBaseZone db = Room.databaseBuilder(getApplicationContext(), AppDataBaseZone.class, "ZoneDataBase").build();
                        ZoneDao zoneDao = db.zoneDao();
                        Zone zone = new Zone();
                        zone.id = idzone;
                        zone.zoneName = name;
                        zoneDao.insertZone(zone);
                    }
                };
                Thread thread = new Thread(runnable);
                thread.start();
                idzone++;
                SharedPreferences.Editor editor = ZoneId.edit();
                editor.putLong(ID, idzone);
                editor.apply();
//                Intent intent = new Intent(AddNewZoneActivity.this, MainActivity.class);
//                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (ZoneId.contains(ID)) {
            idzone = ZoneId.getLong(ID, 0);
        }
    }
}
