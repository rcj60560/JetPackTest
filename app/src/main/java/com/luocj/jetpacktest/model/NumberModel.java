package com.luocj.jetpacktest.model;

import androidx.lifecycle.ViewModel;

public class NumberModel extends ViewModel {
    private int number = 0;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
