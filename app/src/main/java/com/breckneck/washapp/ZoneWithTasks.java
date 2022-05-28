package com.breckneck.washapp;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class ZoneWithTasks {
    @Embedded
    public Zone zone;
    @Relation(
            parentColumn = "id",
            entity = Task.class,
            entityColumn = "zoneid")
    public List<Task> tasks;
}
