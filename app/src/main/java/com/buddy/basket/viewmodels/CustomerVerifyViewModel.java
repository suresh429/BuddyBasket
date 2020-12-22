package com.buddy.basket.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.buddy.basket.model.CustomerResponse;
import com.buddy.basket.network.Repository;
import com.google.gson.JsonObject;

public class CustomerVerifyViewModel extends ViewModel {
    private MutableLiveData<String> toastMessageObserver;
    private MutableLiveData<Boolean> progressbarObservable;
    private MutableLiveData<CustomerResponse> mutableLiveData;
    Repository repository;

    public void initCustomerVerify(String phonenumber,String password, Context context) {
        if (mutableLiveData != null) {
            return;
        }
        repository = Repository.getInstance(context);


        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("phonenumber", phonenumber);
        jsonObject.addProperty("password", password);
        mutableLiveData = repository.getCustomerVerifyData(jsonObject);
        progressbarObservable = repository.getProgressbarObservable();
        toastMessageObserver = repository.getToastObserver();


    }



    public LiveData<CustomerResponse> getRepository() {
        return mutableLiveData;
    }

    public LiveData<String> getToastObserver() {
        return toastMessageObserver;
    }

    public MutableLiveData<Boolean> getProgressbarObservable() {
        return progressbarObservable;
    }


}