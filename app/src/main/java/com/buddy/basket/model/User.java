package com.buddy.basket.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.buddy.basket.BR;

public class User extends BaseObservable {

    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }
}
