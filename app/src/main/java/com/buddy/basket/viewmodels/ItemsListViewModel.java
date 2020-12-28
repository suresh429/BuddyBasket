package com.buddy.basket.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.buddy.basket.model.ItemsListResponse;
import com.buddy.basket.network.Repository;
import com.google.gson.JsonObject;

public class ItemsListViewModel extends ViewModel {
    private MutableLiveData<String> toastMessageObserver;
    private MutableLiveData<Boolean> progressbarObservable;
    private MutableLiveData<ItemsListResponse> mutableLiveData;


    public void init(int id,String customer_id, Context context) {
        if (mutableLiveData != null) {
            return;
        }
        Repository repository = Repository.getInstance(context);


        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("shop_id", id);
        jsonObject.addProperty("customer_id", customer_id);

        mutableLiveData = repository.getItemsListData(jsonObject);
        progressbarObservable = repository.getProgressbarObservable();
        toastMessageObserver = repository.getToastObserver();


    }

    public LiveData<ItemsListResponse> getRepository() {
        return mutableLiveData;
    }

    public LiveData<String> getToastObserver() {
        return toastMessageObserver;
    }

    public MutableLiveData<Boolean> getProgressbarObservable() {
        return progressbarObservable;
    }


}