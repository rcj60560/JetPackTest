package com.luocj.jetpacktest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.luocj.jetpacktest.activity.ScoreActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button(View view) {
        startActivity(new Intent(MainActivity.this, ScoreActivity.class));
    }
}
