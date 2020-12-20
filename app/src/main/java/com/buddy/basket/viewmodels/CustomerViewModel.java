package com.buddy.basket.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.buddy.basket.model.CustomerResponse;
import com.buddy.basket.model.ShopsListResponse;
import com.buddy.basket.network.JournalRepository;
import com.google.gson.JsonObject;

public class CustomerViewModel extends ViewModel {
    private MutableLiveData<String> toastMessageObserver;
    private MutableLiveData<Boolean> progressbarObservable;
    private MutableLiveData<CustomerResponse> mutableLiveData;


    public void initCustomer(String phonenumber, Context context) {
        if (mutableLiveData != null) {
            return;
        }
        JournalRepository journalRepository = JournalRepository.getInstance(context);


        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("phonenumber", phonenumber);
        mutableLiveData = journalRepository.getCustomerData(jsonObject);
        progressbarObservable = journalRepository.getProgressbarObservable();
        toastMessageObserver = journalRepository.getToastObserver();


    }

    public void initCustomerVerify(String phonenumber,String password, Context context) {
        if (mutableLiveData != null) {
            return;
        }
        JournalRepository journalRepository = JournalRepository.getInstance(context);


        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("phonenumber", phonenumber);
        jsonObject.addProperty("password", password);
        mutableLiveData = journalRepository.getCustomerVerifyData(jsonObject);
        progressbarObservable = journalRepository.getProgressbarObservable();
        toastMessageObserver = journalRepository.getToastObserver();


    }

    public void initCustomerInsert(String name,String phonenumber,String password, Context context) {
        if (mutableLiveData != null) {
            return;
        }
        JournalRepository journalRepository = JournalRepository.getInstance(context);


        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", name);
        jsonObject.addProperty("phonenumber", phonenumber);
        jsonObject.addProperty("password", password);
        mutableLiveData = journalRepository.getCustomerInsertData(jsonObject);
        progressbarObservable = journalRepository.getProgressbarObservable();
        toastMessageObserver = journalRepository.getToastObserver();


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