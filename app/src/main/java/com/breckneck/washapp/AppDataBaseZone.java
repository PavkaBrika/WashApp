package com.breckneck.washapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Zone.class, Task.class}, version = 5)
public abstract class AppDataBaseZone extends RoomDatabase {
    public abstract ZoneDao zoneDao();
}
