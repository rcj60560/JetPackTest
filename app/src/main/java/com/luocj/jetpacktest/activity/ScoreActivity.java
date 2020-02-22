package com.luocj.jetpacktest.activity;

import android.os.Bundle;
import android.widget.ScrollView;

import com.luocj.jetpacktest.R;
import com.luocj.jetpacktest.databinding.ActivityScoreBinding;
import com.luocj.jetpacktest.model.ScoreModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

/**
 * 篮球计分器的demo
 * 2020年2月22日15:40:19
 */
public class ScoreActivity extends AppCompatActivity {

    ScoreModel scoreModel;
    ActivityScoreBinding scoreBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scoreBinding = DataBindingUtil.setContentView(this, R.layout.activity_score);
        scoreModel = new ViewModelProvider(this).get(ScoreModel.class);

        scoreBinding.setData(scoreModel);
        scoreBinding.setLifecycleOwner(this);

    }
}
