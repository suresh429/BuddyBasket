package com.buddy.basket.network;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.buddy.basket.model.ResItemsListResponse;
import com.buddy.basket.model.RestaurantListResponse;
import com.google.gson.JsonObject;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JournalRepository {
    private MutableLiveData<String> toastMessageObserver;
    private MutableLiveData<Boolean> progressbarObservable;
    private static JournalRepository journalRepository;

    public static JournalRepository getInstance(Context context) {
        if (journalRepository == null) {
            journalRepository = new JournalRepository(context);

        }
        return journalRepository;
    }

    private Api newsApi;


    public JournalRepository(Context context) {
        newsApi = RetrofitService.createService(Api.class,context);
        progressbarObservable = new MutableLiveData<>();
        toastMessageObserver = new MutableLiveData<>();
    }

    public MutableLiveData<Boolean> getProgressbarObservable() {
        return progressbarObservable;
    }

    public MutableLiveData<String> getToastObserver() {
        return toastMessageObserver;
    }

    // getting restaurant data response
    public MutableLiveData<RestaurantListResponse> getRestaurantData(JsonObject jsonObject) {
        progressbarObservable.setValue(true);
        MutableLiveData<RestaurantListResponse> homeData = new MutableLiveData<>();
        newsApi.getRestaurantList(jsonObject).enqueue(new Callback<RestaurantListResponse>() {
            @Override
            public void onResponse(@NotNull Call<RestaurantListResponse> call, @NotNull Response<RestaurantListResponse> response) {
                if (response.isSuccessful()) {
                    progressbarObservable.setValue(false);
                    homeData.setValue(response.body());
                } else {
                    progressbarObservable.setValue(false);
                    toastMessageObserver.setValue("Something unexpected happened to our request: " + response.message()); // Whenever you want to show toast use setValue.

                }
            }

            @Override
            public void onFailure(@NotNull Call<RestaurantListResponse> call, @NotNull Throwable t) {
                if (t instanceof NoConnectivityException) {
                    // show No Connectivity message to user or do whatever you want.
                    toastMessageObserver.setValue(t.getMessage());
                    // Whenever you want to show toast use setValue.

                }
                // homeData.setValue(null);
                progressbarObservable.setValue(false);
            }
        });
        return homeData;
    }

    // getting list items data response
    public MutableLiveData<ResItemsListResponse> getRestaurantItemsData(JsonObject jsonObject) {
        progressbarObservable.setValue(true);
        MutableLiveData<ResItemsListResponse> homeData = new MutableLiveData<>();
        newsApi.getItemsList(jsonObject).enqueue(new Callback<ResItemsListResponse>() {
            @Override
            public void onResponse(@NotNull Call<ResItemsListResponse> call, @NotNull Response<ResItemsListResponse> response) {
                if (response.isSuccessful()) {
                    progressbarObservable.setValue(false);
                    homeData.setValue(response.body());
                } else {
                    progressbarObservable.setValue(false);
                    toastMessageObserver.setValue("Something unexpected happened to our request: " + response.message()); // Whenever you want to show toast use setValue.

                }
            }

            @Override
            public void onFailure(@NotNull Call<ResItemsListResponse> call, @NotNull Throwable t) {
                if (t instanceof NoConnectivityException) {
                    // show No Connectivity message to user or do whatever you want.
                    toastMessageObserver.setValue(t.getMessage());
                    // Whenever you want to show toast use setValue.

                }
                // homeData.setValue(null);
                progressbarObservable.setValue(false);
            }
        });
        return homeData;
    }


}
