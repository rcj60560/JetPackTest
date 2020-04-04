package com.luocj.jetpacktest.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Word {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "english_word")
    private String word;

    @ColumnInfo(name = "")
    private String chinesMeaning;

    public Word(String word, String chinesMeaning) {
        this.word = word;
        this.chinesMeaning = chinesMeaning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getChinesMeaning() {
        return chinesMeaning;
    }

    public void setChinesMeaning(String chinesMeaning) {
        this.chinesMeaning = chinesMeaning;
    }
}
