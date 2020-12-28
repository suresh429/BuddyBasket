package com.buddy.basket.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.buddy.basket.model.AddressResponse;
import com.buddy.basket.network.Repository;
import com.google.gson.JsonObject;

public class AddressViewModel extends ViewModel {

    private MutableLiveData<String> toastMessageObserver;
    private MutableLiveData<Boolean> progressbarObservable;
    private MutableLiveData<AddressResponse> mutableLiveData;


    public void initAddress(String customer_id, Context context) {
        if (mutableLiveData != null) {
            return;
        }
        Repository repository = Repository.getInstance(context);


        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("customer_id", customer_id);
        mutableLiveData = repository.getAddressData(jsonObject);
        progressbarObservable = repository.getProgressbarObservable();
        toastMessageObserver = repository.getToastObserver();


    }

    public void initInsertAddress(String customer_id, String addr1, String addr2, String landmark, String pincode,
                                  String name,String phone,Context context) {
        if (mutableLiveData != null) {
            return;
        }
        Repository repository = Repository.getInstance(context);


        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("customer_id", customer_id);
        jsonObject.addProperty("addr1", addr1);
        jsonObject.addProperty("addr2", addr2);
        jsonObject.addProperty("landmark", landmark);
        jsonObject.addProperty("name", name);
        jsonObject.addProperty("phone", phone);
        jsonObject.addProperty("pincode", pincode);

        mutableLiveData = repository.getInsertAddressData(jsonObject);
        progressbarObservable = repository.getProgressbarObservable();
        toastMessageObserver = repository.getToastObserver();


    }

    public void initUpdateAddress(String customer_id, String id, String addr1, String addr2, String landmark,
                                  String name,String phone,String pincode, Context context) {
        if (mutableLiveData != null) {
            return;
        }
        Repository repository = Repository.getInstance(context);


        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("customer_id", customer_id);
        jsonObject.addProperty("id", id);
        jsonObject.addProperty("addr1", addr1);
        jsonObject.addProperty("addr2", addr2);
        jsonObject.addProperty("landmark", landmark);
        jsonObject.addProperty("name", name);
        jsonObject.addProperty("phone", phone);
        jsonObject.addProperty("pincode", pincode);

        mutableLiveData = repository.getUpdateAddressData(jsonObject);
        progressbarObservable = repository.getProgressbarObservable();
        toastMessageObserver = repository.getToastObserver();


    }

    public void initDeleteAddress(String customer_id, String id, Context context) {
        if (mutableLiveData != null) {
            return;
        }
        Repository repository = Repository.getInstance(context);


        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("customer_id", customer_id);
        jsonObject.addProperty("id", id);
        mutableLiveData = repository.getDeleteAddressData(jsonObject);
        progressbarObservable = repository.getProgressbarObservable();
        toastMessageObserver = repository.getToastObserver();


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