package com.luocj.jetpacktest.activity.room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.luocj.jetpacktest.R;
import com.luocj.jetpacktest.model.Word;
import com.luocj.jetpacktest.model.WordDao;
import com.luocj.jetpacktest.model.WordDatabase;

import java.util.List;

//room 增删改查基本使用
public class RoomTest1Activity extends AppCompatActivity {
    private TextView textView;
    private Button btnInsert, btnClear, btnUpdate, btnDelete;
    private WordDao wordDao;
    private WordDatabase wordDatabase;
    private List<Word> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_test1);
        textView = findViewById(R.id.textView9);
        btnInsert = findViewById(R.id.button12);
        btnClear = findViewById(R.id.button13);
        btnUpdate = findViewById(R.id.button14);
        btnDelete = findViewById(R.id.button15);

        wordDatabase = Room.databaseBuilder(this, WordDatabase.class, "word_database")
                .allowMainThreadQueries()
                .build();
        wordDao = wordDatabase.getWordDao();

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word("hello", "你好，");
                Word word1 = new Word("world", "世界");
                wordDao.insertWord(word, word1);
                updateView();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wordDao.deleteAllWord();
                updateView();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word("test", "更新");
                word.setId(80);
                wordDao.updateWord(word);
                updateView();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word("", "");
                word.setId(88);
                wordDao.deleteWord(word);
                updateView();
            }
        });




    }

    void updateView() {
        list = wordDao.getAllWords();
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            Word word = list.get(i);
            str += word.getId() + ":" + word.getWord() + ":" + word.getChinesMeaning() + "\n";
        }
        textView.setText(str);
    }
}
