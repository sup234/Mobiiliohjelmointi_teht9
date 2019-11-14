package com.example.teht9;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Time;

public class MyEntity2 {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String user;
    public String loginAttempt;
    public Time timestamp;
}
