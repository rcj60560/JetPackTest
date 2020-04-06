package com.luocj.jetpacktest.activity.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.luocj.jetpacktest.model.Person;
import com.luocj.jetpacktest.model.Word;

import java.util.List;

@Dao
public interface PersonDao {

    @Insert
    void insertPersion(Person... person);

    @Delete
    void deletetPersion(Person... person);

    @Update
    void updatePersion(Person... person);

    @Query("DELETE FROM PERSON")
    void deleteAllWord();

    @Query("SELECT * FROM PERSON ORDER BY ID DESC")
//    List<Person> getAllWords();

    LiveData<List<Person>> getAllPerson();
}
