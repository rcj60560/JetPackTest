package com.luocj.jetpacktest.activity.dao;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.luocj.jetpacktest.model.Person;


@Database(entities = {Person.class}, version = 1, exportSchema = false)
public abstract class PersonDatabase extends RoomDatabase {

    private static PersonDatabase INSTANCE;

    public static synchronized PersonDatabase getINSTANCE(Context con) {

        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(con.getApplicationContext(), PersonDatabase.class, "person")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
    public abstract PersonDao getPersonDao();
}
