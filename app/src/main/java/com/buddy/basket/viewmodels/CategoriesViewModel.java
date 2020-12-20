package com.buddy.basket.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.buddy.basket.model.CategoriesResponse;
import com.buddy.basket.model.ShopsListResponse;
import com.buddy.basket.network.JournalRepository;
import com.google.gson.JsonObject;

public class CategoriesViewModel extends ViewModel {

    private MutableLiveData<String> toastMessageObserver;
    private MutableLiveData<Boolean> progressbarObservable;
    private MutableLiveData<CategoriesResponse> mutableLiveData;


    public void initCategories( Context context) {
        if (mutableLiveData != null) {
            return;
        }
        JournalRepository journalRepository = JournalRepository.getInstance(context);

        mutableLiveData = journalRepository.getCategoriesData();
        progressbarObservable = journalRepository.getProgressbarObservable();
        toastMessageObserver = journalRepository.getToastObserver();


    }

    public LiveData<CategoriesResponse> getRepository() {
        return mutableLiveData;
    }

    public LiveData<String> getToastObserver() {
        return toastMessageObserver;
    }

    public MutableLiveData<Boolean> getProgressbarObservable() {
        return progressbarObservable;
    }
}