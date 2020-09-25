package com.buddy.basket.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.buddy.basket.model.RestaurantListResponse;
import com.buddy.basket.network.JournalRepository;
import com.google.gson.JsonObject;

public class RestaurantsViewModel extends ViewModel {
    private MutableLiveData<String> toastMessageObserver;
    private MutableLiveData<Boolean> progressbarObservable;
    private MutableLiveData<RestaurantListResponse> mutableLiveData;


    public void init(String city,String area, Context context) {
        if (mutableLiveData != null) {
            return;
        }
        JournalRepository journalRepository = JournalRepository.getInstance(context);


        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("city", city);
        jsonObject.addProperty("area", area);
        mutableLiveData = journalRepository.getRestaurantData(jsonObject);
        progressbarObservable = journalRepository.getProgressbarObservable();
        toastMessageObserver = journalRepository.getToastObserver();


    }

    public LiveData<RestaurantListResponse> getRepository() {
        return mutableLiveData;
    }

    public LiveData<String> getToastObserver() {
        return toastMessageObserver;
    }

    public MutableLiveData<Boolean> getProgressbarObservable() {
        return progressbarObservable;
    }


}