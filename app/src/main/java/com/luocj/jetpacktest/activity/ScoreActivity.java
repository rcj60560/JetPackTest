package com.luocj.jetpacktest.activity;

import android.os.Bundle;

import com.luocj.jetpacktest.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 篮球计分器的demo
 * 2020年2月22日15:40:19
 */
public class ScoreActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
    }
}
