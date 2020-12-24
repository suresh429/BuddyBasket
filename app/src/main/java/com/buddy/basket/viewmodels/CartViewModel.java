package com.buddy.basket.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.buddy.basket.model.CartResponse;
import com.buddy.basket.network.Repository;
import com.google.gson.JsonObject;

public class CartViewModel extends ViewModel {

    private MutableLiveData<String> toastMessageObserver;
    private MutableLiveData<Boolean> progressbarObservable;
    private MutableLiveData<CartResponse> mutableLiveData;


    public void initInsertCart(String customer_id,int item_id, int qty, Context context) {
        if (mutableLiveData != null) {
            return;
        }
        Repository repository = Repository.getInstance(context);


        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("customer_id", customer_id);
        jsonObject.addProperty("item_id", item_id);
        jsonObject.addProperty("qty", qty);
        mutableLiveData = repository.getCartInsertData(jsonObject);
        progressbarObservable = repository.getProgressbarObservable();
        toastMessageObserver = repository.getToastObserver();


    }

    public void initUpdateCart(String customer_id,int item_id, int qty, Context context) {
        if (mutableLiveData != null) {
            return;
        }
        Repository repository = Repository.getInstance(context);


        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("customer_id", customer_id);
        jsonObject.addProperty("item_id", item_id);
        jsonObject.addProperty("qty", qty);
        mutableLiveData = repository.getCartUpdateData(jsonObject);
        progressbarObservable = repository.getProgressbarObservable();
        toastMessageObserver = repository.getToastObserver();


    }

    public void initViewCart(String customer_id, Context context) {
        if (mutableLiveData != null) {
            return;
        }
        Repository repository = Repository.getInstance(context);


        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("customer_id", customer_id);
        mutableLiveData = repository.getCartViewData(jsonObject);
        progressbarObservable = repository.getProgressbarObservable();
        toastMessageObserver = repository.getToastObserver();


    }


    public LiveData<CartResponse> getRepository() {
        return mutableLiveData;
    }

    public LiveData<String> getToastObserver() {
        return toastMessageObserver;
    }

    public MutableLiveData<Boolean> getProgressbarObservable() {
        return progressbarObservable;
    }
}