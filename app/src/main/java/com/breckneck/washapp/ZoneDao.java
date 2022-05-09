package com.breckneck.washapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface ZoneDao {

    @Query("SELECT * FROM zone")
    List<Zone> getAll();

    @Query("SELECT * FROM zone WHERE id = :id")
    Zone getById(long id);

    @Insert
    void insert(Zone zone);

    @Update
    void update(Zone zone);

    @Delete
    void delete(Zone zone);
}
