package com.breckneck.washapp.model;

public class Zone {

    public long id;
    public String zoneName;
    public int picture;


    public Zone(long id, String zoneName, int picture) {
        this.id = id;
        this.zoneName = zoneName;
        this.picture = picture;
    }

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

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}