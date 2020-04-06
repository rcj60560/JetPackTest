package com.luocj.jetpacktest.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.luocj.jetpacktest.R;
import com.luocj.jetpacktest.model.MyLiveDataModel;

public class LiveDataActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    private MyLiveDataModel liveDataModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livedata);
        textView = findViewById(R.id.textView7);
        button = findViewById(R.id.button7);

        liveDataModel = new ViewModelProvider(this).get(MyLiveDataModel.class);

        textView.setText(String.valueOf(liveDataModel.getNumber().getValue()));
        liveDataModel.getNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setText(String.valueOf(liveDataModel.getNumber().getValue()));
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liveDataModel.add();
            }
        });
    }
}
