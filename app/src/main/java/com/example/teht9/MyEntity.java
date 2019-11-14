package com.example.teht9;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MyEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String user;
    public String password;

}
