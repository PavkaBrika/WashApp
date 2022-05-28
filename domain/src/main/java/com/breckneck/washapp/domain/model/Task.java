package com.breckneck.washapp.domain.model;

public class Task {

    public long id;
    public long zoneId;
    public String taskName;


    public Task(long id, long zoneId, String taskName) {
        this.id = id;
        this.zoneId = zoneId;
        this.taskName = taskName;
    }
}
