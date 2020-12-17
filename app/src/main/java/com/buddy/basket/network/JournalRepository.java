package com.buddy.basket.network;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.buddy.basket.model.ItemsListResponse;
import com.buddy.basket.model.ShopsListResponse;
import com.google.gson.JsonObject;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.buddy.basket.network.RetrofitService.*;

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

   private ApiInterface newsApiInterface;

    public JournalRepository(Context context) {

        newsApiInterface = createService(ApiInterface.class, context);
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
    public MutableLiveData<ShopsListResponse> getShopsListData(JsonObject jsonObject) {
        progressbarObservable.setValue(true);
        MutableLiveData<ShopsListResponse> homeData = new MutableLiveData<>();

        newsApiInterface.getShopsList(jsonObject).enqueue(new Callback<ShopsListResponse>() {
            @Override
            public void onResponse(@NotNull Call<ShopsListResponse> call, @NotNull Response<ShopsListResponse> response) {
                if (response.isSuccessful()) {
                    progressbarObservable.setValue(false);
                    homeData.setValue(response.body());
                } else {
                    progressbarObservable.setValue(false);
                    toastMessageObserver.setValue("Something unexpected happened to our request: " + response.message()); // Whenever you want to show toast use setValue.

                }
            }

            @Override
            public void onFailure(@NotNull Call<ShopsListResponse> call, @NotNull Throwable t) {
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
    public MutableLiveData<ItemsListResponse> getItemsListData(JsonObject jsonObject) {
        progressbarObservable.setValue(true);
        MutableLiveData<ItemsListResponse> homeData = new MutableLiveData<>();
        newsApiInterface.getItemsList(jsonObject).enqueue(new Callback<ItemsListResponse>() {
            @Override
            public void onResponse(@NotNull Call<ItemsListResponse> call, @NotNull Response<ItemsListResponse> response) {
                if (response.isSuccessful()) {
                    progressbarObservable.setValue(false);
                    homeData.setValue(response.body());
                } else {
                    progressbarObservable.setValue(false);
                    toastMessageObserver.setValue("Something unexpected happened to our request: " + response.message()); // Whenever you want to show toast use setValue.

                }
            }

            @Override
            public void onFailure(@NotNull Call<ItemsListResponse> call, @NotNull Throwable t) {
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
