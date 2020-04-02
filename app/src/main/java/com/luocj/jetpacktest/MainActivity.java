package com.luocj.jetpacktest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.luocj.jetpacktest.activity.DataBindingActivity;
import com.luocj.jetpacktest.activity.LifeCyclerActivity;
import com.luocj.jetpacktest.activity.LiveDataActivity;
import com.luocj.jetpacktest.activity.NavigationActivity;
import com.luocj.jetpacktest.activity.RoomTestActivity;
import com.luocj.jetpacktest.activity.ScoreActivity;
import com.luocj.jetpacktest.activity.SplashActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button(View view) {
        startActivity(new Intent(MainActivity.this, ScoreActivity.class));
    }

    public void btn1(View view) {
        startActivity(new Intent(MainActivity.this, LifeCyclerActivity.class));
    }

    //livedata
    public void btn2(View view) {
        startActivity(new Intent(MainActivity.this, LiveDataActivity.class));
    }

    //databinding
    public void btn3(View view) {
        startActivity(new Intent(MainActivity.this, DataBindingActivity.class));
    }

    //navigation
    public void btn4(View view) {
        startActivity(new Intent(MainActivity.this, NavigationActivity.class));
    }

    //ppjoker
    public void btn5(View view) {
        startActivity(new Intent(MainActivity.this, SplashActivity.class));
    }

    //    Room
    public void btn6(View view) {
        startActivity(new Intent(MainActivity.this, RoomTestActivity.class ));
    }
}
