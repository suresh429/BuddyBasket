package com.buddy.basket.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.buddy.basket.model.CartResponse;
import com.buddy.basket.model.PlaceOrderResponse;
import com.buddy.basket.network.JournalRepository;
import com.google.gson.JsonObject;

public class PlaceOrderViewModel extends ViewModel {

    private MutableLiveData<String> toastMessageObserver;
    private MutableLiveData<Boolean> progressbarObservable;
    private MutableLiveData<PlaceOrderResponse> mutableLiveData;


    public void initPlaceOrder(String customer_id,String total_amt, String customer_comments,String address_id, Context context) {
        if (mutableLiveData != null) {
            return;
        }
        JournalRepository journalRepository = JournalRepository.getInstance(context);


        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("customer_id", customer_id);
        jsonObject.addProperty("total_amt", total_amt);
        jsonObject.addProperty("customer_comments", customer_comments);
        jsonObject.addProperty("address_id", address_id);
        mutableLiveData = journalRepository.getPlaceOrderData(jsonObject);
        progressbarObservable = journalRepository.getProgressbarObservable();
        toastMessageObserver = journalRepository.getToastObserver();


    }



    public LiveData<PlaceOrderResponse> getRepository() {
        return mutableLiveData;
    }

    public LiveData<String> getToastObserver() {
        return toastMessageObserver;
    }

    public MutableLiveData<Boolean> getProgressbarObservable() {
        return progressbarObservable;
    }
}