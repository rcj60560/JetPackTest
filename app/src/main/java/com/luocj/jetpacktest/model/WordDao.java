package com.luocj.jetpacktest.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao //database access object
public interface WordDao {
    @Insert
    void insertWord(Word... words);

    @Update
    void updateWord(Word... words);

    @Delete
    void deleteWord(Word... words);

    @Query("DELETE FROM WORD")
    void deleteAllWord();

    @Query("SELECT * FROM WORD ORDER BY ID DESC")
    List<Word> getAllWords();

}
