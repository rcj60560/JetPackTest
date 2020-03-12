package com.luocj.jetpacktest.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Timer;

public class MyLiveDataModel extends ViewModel {
    private MutableLiveData<Integer> number;

    public MutableLiveData<Integer> getNumber() {
        if (number == null) {
            number = new MutableLiveData<>();
            number.setValue(0);
        }
        return number;
    }

    public void add() {
        if (number.getValue() != null) {
            number.setValue(number.getValue() + 1);
        }
    }

    public void setNumber(MutableLiveData<Integer> number) {
        this.number = number;
    }
}
