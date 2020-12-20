package com.buddy.basket.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.buddy.basket.model.ShopsListResponse;
import com.buddy.basket.network.JournalRepository;
import com.google.gson.JsonObject;

public class HistoryViewModel extends ViewModel {

    private MutableLiveData<String> toastMessageObserver;
    private MutableLiveData<Boolean> progressbarObservable;
    private MutableLiveData<ShopsListResponse> mutableLiveData;


    public void initShops(String city,String area, Context context) {
        if (mutableLiveData != null) {
            return;
        }
        JournalRepository journalRepository = JournalRepository.getInstance(context);


        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("city", city);
        jsonObject.addProperty("area", area);
        mutableLiveData = journalRepository.getShopsListData(jsonObject);
        progressbarObservable = journalRepository.getProgressbarObservable();
        toastMessageObserver = journalRepository.getToastObserver();


    }

    public LiveData<ShopsListResponse> getRepository() {
        return mutableLiveData;
    }

    public LiveData<String> getToastObserver() {
        return toastMessageObserver;
    }

    public MutableLiveData<Boolean> getProgressbarObservable() {
        return progressbarObservable;
    }
}