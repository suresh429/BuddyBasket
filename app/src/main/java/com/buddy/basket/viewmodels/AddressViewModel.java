package com.buddy.basket.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.buddy.basket.model.AddressResponse;
import com.buddy.basket.model.CartResponse;
import com.buddy.basket.network.JournalRepository;
import com.google.gson.JsonObject;

public class AddressViewModel extends ViewModel {

    private MutableLiveData<String> toastMessageObserver;
    private MutableLiveData<Boolean> progressbarObservable;
    private MutableLiveData<AddressResponse> mutableLiveData;


    public void initAddress(String customer_id, Context context) {
        if (mutableLiveData != null) {
            return;
        }
        JournalRepository journalRepository = JournalRepository.getInstance(context);


        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("customer_id", customer_id);
        mutableLiveData = journalRepository.getAddressData(jsonObject);
        progressbarObservable = journalRepository.getProgressbarObservable();
        toastMessageObserver = journalRepository.getToastObserver();


    }

    public void initInsertAddress(String customer_id, String addr1, String addr2, String landmark, String pincode, Context context) {
        if (mutableLiveData != null) {
            return;
        }
        JournalRepository journalRepository = JournalRepository.getInstance(context);


        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("customer_id", customer_id);
        jsonObject.addProperty("addr1", addr1);
        jsonObject.addProperty("addr2", addr2);
        jsonObject.addProperty("landmark", landmark);
        jsonObject.addProperty("pincode", pincode);

        mutableLiveData = journalRepository.getInsertAddressData(jsonObject);
        progressbarObservable = journalRepository.getProgressbarObservable();
        toastMessageObserver = journalRepository.getToastObserver();


    }

    public void initUpdateAddress(String customer_id, String id, String addr1, String addr2, String landmark, String pincode, Context context) {
        if (mutableLiveData != null) {
            return;
        }
        JournalRepository journalRepository = JournalRepository.getInstance(context);


        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("customer_id", customer_id);
        jsonObject.addProperty("id", id);
        jsonObject.addProperty("addr1", addr1);
        jsonObject.addProperty("addr2", addr2);
        jsonObject.addProperty("landmark", landmark);
        jsonObject.addProperty("pincode", pincode);

        mutableLiveData = journalRepository.getUpdateAddressData(jsonObject);
        progressbarObservable = journalRepository.getProgressbarObservable();
        toastMessageObserver = journalRepository.getToastObserver();


    }

    public void initDeleteAddress(String customer_id, String id, Context context) {
        if (mutableLiveData != null) {
            return;
        }
        JournalRepository journalRepository = JournalRepository.getInstance(context);


        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("customer_id", customer_id);
        jsonObject.addProperty("id", id);
        mutableLiveData = journalRepository.getDeleteAddressData(jsonObject);
        progressbarObservable = journalRepository.getProgressbarObservable();
        toastMessageObserver = journalRepository.getToastObserver();


    }

    public LiveData<AddressResponse> getRepository() {
        return mutableLiveData;
    }

    public LiveData<String> getToastObserver() {
        return toastMessageObserver;
    }

    public MutableLiveData<Boolean> getProgressbarObservable() {
        return progressbarObservable;
    }
}