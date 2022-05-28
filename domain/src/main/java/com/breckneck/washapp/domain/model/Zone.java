package com.breckneck.washapp.domain.model;

public class Zone {

    public long id;
    public String zoneName;
    public int picture;


    public Zone(long id, String zoneName, int picture) {
        this.id = id;
        this.zoneName = zoneName;
        this.picture = picture;
    }
}
