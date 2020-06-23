package com.luocj.jetpacktest.activity;

import android.database.DatabaseUtils;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;

import com.luocj.jetpacktest.R;
import com.luocj.jetpacktest.databinding.ActivityDatabindingBinding;
import com.luocj.jetpacktest.model.MyLiveDataModel;
import com.luocj.jetpacktest.model.NumberModel;

public class DataBindingActivity extends AppCompatActivity {
    private Button btn1;
    private TextView tv1;
    private ActivityDatabindingBinding databindingBinding;
    private MyLiveDataModel dataModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databindingBinding = DataBindingUtil.setContentView(this, R.layout.activity_databinding);
        dataModel = new ViewModelProvider(this).get(MyLiveDataModel.class);
        databindingBinding.setMydata(dataModel);
        databindingBinding.setLifecycleOwner(this);
    }
}
