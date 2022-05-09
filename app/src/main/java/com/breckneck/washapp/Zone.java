package com.breckneck.washapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Zone {

    @PrimaryKey
    public long id;
    public String zoneName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }
}