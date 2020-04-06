package com.luocj.jetpacktest.activity.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.luocj.jetpacktest.R;

/**
 * room 数据库使用
 * 2020年4月2日10:58:44
 */
public class RoomTestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
    }

    //增删改查基础使用
    public void btn1(View view) {
        startActivity(new Intent(RoomTestActivity.this, RoomTest1Activity.class));
    }

    //rom使用优化
    public void btn2(View view) {
        startActivity(new Intent(RoomTestActivity.this, RoomTest2Activity.class));
    }
}
