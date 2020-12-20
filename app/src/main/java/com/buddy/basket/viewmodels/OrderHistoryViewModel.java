package com.buddy.basket.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.buddy.basket.model.CitiesResponse;
import com.buddy.basket.model.OrderHistoryResponse;
import com.buddy.basket.network.JournalRepository;
import com.google.gson.JsonObject;

public class OrderHistoryViewModel extends ViewModel {

    private MutableLiveData<String> toastMessageObserver;
    private MutableLiveData<Boolean> progressbarObservable;
    private MutableLiveData<OrderHistoryResponse> mutableLiveData;


    public void initOrderHistory(String customer_id, Context context) {
        if (mutableLiveData != null) {
            return;
        }
        JournalRepository journalRepository = JournalRepository.getInstance(context);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("customer_id", customer_id);

        mutableLiveData = journalRepository.getOrderHistoryData(jsonObject);
        progressbarObservable = journalRepository.getProgressbarObservable();
        toastMessageObserver = journalRepository.getToastObserver();


    }

    public LiveData<OrderHistoryResponse> getRepository() {
        return mutableLiveData;
    }

    public LiveData<String> getToastObserver() {
        return toastMessageObserver;
    }

    public MutableLiveData<Boolean> getProgressbarObservable() {
        return progressbarObservable;
    }
}