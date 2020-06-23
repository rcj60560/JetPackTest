package com.luocj.jetpacktest.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.luocj.jetpacktest.R;
import com.luocj.jetpacktest.model.NumberModel;


public class LifeCyclerActivity extends AppCompatActivity {

    private NumberModel numberModel;
    private Button btn1;
    private TextView tv1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        btn1 = findViewById(R.id.btn1);
        tv1 = findViewById(R.id.tvNumber1);

        //test
        numberModel = new ViewModelProvider(this).get(NumberModel.class);

        NumberModel numberModel = new ViewModelProvider(this).get(this.numberModel.getClass());

        tv1.setText(String.valueOf(this.numberModel.getNumber()));
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LifeCyclerActivity.this.numberModel.setNumber(LifeCyclerActivity.this.numberModel.getNumber() + 1);
                tv1.setText(String.valueOf(LifeCyclerActivity.this.numberModel.getNumber()));
            }
        });
    }
}
