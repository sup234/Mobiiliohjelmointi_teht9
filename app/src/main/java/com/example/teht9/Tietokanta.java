package com.example.teht9;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {MyEntity.class}, version = 1)
public abstract class Tietokanta extends RoomDatabase {
    private static volatile Tietokanta INSTANCE;

    static Tietokanta getTietokanta(final Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), Tietokanta.class, "database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract MyTableDao myTableDao();
}
