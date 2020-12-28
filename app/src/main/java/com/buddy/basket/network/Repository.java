package com.buddy.basket.network;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.buddy.basket.model.AddressResponse;
import com.buddy.basket.model.CartResponse;
import com.buddy.basket.model.CategoriesResponse;
import com.buddy.basket.model.CitiesResponse;
import com.buddy.basket.model.CustomerResponse;
import com.buddy.basket.model.ItemDetailsResponse;
import com.buddy.basket.model.ItemsListResponse;
import com.buddy.basket.model.OrderHistoryResponse;
import com.buddy.basket.model.PlaceOrderResponse;
import com.buddy.basket.model.ShopsListResponse;
import com.google.gson.JsonObject;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.buddy.basket.network.RetrofitService.*;

public class Repository {
    private MutableLiveData<String> toastMessageObserver;
    private MutableLiveData<Boolean> progressbarObservable;
    private static Repository repository;

    public static Repository getInstance(Context context) {
        if (repository == null) {
            repository = new Repository(context);

        }
        return repository;
    }

   private ApiInterface newsApiInterface;

    public Repository(Context context) {

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

    // getting customer data response
    public MutableLiveData<CustomerResponse> getCustomerData(JsonObject jsonObject) {
        progressbarObservable.setValue(true);
        MutableLiveData<CustomerResponse> homeData = new MutableLiveData<>();
        newsApiInterface.getCustomerList(jsonObject).enqueue(new Callback<CustomerResponse>() {
            @Override
            public void onResponse(@NotNull Call<CustomerResponse> call, @NotNull Response<CustomerResponse> response) {
                if (response.isSuccessful()) {
                    progressbarObservable.setValue(false);
                    homeData.setValue(response.body());
                } else {
                    progressbarObservable.setValue(false);
                    toastMessageObserver.setValue("Something unexpected happened to our request: " + response.message()); // Whenever you want to show toast use setValue.

                }
            }

            @Override
            public void onFailure(@NotNull Call<CustomerResponse> call, @NotNull Throwable t) {
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

    // getting customer verify data response
    public MutableLiveData<CustomerResponse> getCustomerVerifyData(JsonObject jsonObject) {
        progressbarObservable.setValue(true);
        MutableLiveData<CustomerResponse> homeData = new MutableLiveData<>();
        newsApiInterface.getCustomerVerifyList(jsonObject).enqueue(new Callback<CustomerResponse>() {
            @Override
            public void onResponse(@NotNull Call<CustomerResponse> call, @NotNull Response<CustomerResponse> response) {
                if (response.isSuccessful()) {
                    progressbarObservable.setValue(false);
                    homeData.setValue(response.body());
                } else {
                    progressbarObservable.setValue(false);
                    toastMessageObserver.setValue("Something unexpected happened to our request: " + response.message()); // Whenever you want to show toast use setValue.

                }
            }

            @Override
            public void onFailure(@NotNull Call<CustomerResponse> call, @NotNull Throwable t) {
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

    // getting customer insert data response
    public MutableLiveData<CustomerResponse> getCustomerInsertData(JsonObject jsonObject) {
        progressbarObservable.setValue(true);
        MutableLiveData<CustomerResponse> homeData = new MutableLiveData<>();
        newsApiInterface.getCustomerInsertList(jsonObject).enqueue(new Callback<CustomerResponse>() {
            @Override
            public void onResponse(@NotNull Call<CustomerResponse> call, @NotNull Response<CustomerResponse> response) {
                if (response.isSuccessful()) {
                    progressbarObservable.setValue(false);
                    homeData.setValue(response.body());
                } else {
                    progressbarObservable.setValue(false);
                    toastMessageObserver.setValue("Something unexpected happened to our request: " + response.message()); // Whenever you want to show toast use setValue.

                }
            }

            @Override
            public void onFailure(@NotNull Call<CustomerResponse> call, @NotNull Throwable t) {
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

    // getting items data response
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

    // getting item details data response
    public MutableLiveData<ItemDetailsResponse> getItemDetailsData(JsonObject jsonObject) {
        progressbarObservable.setValue(true);
        MutableLiveData<ItemDetailsResponse> homeData = new MutableLiveData<>();
        newsApiInterface.getItemsDetailsList(jsonObject).enqueue(new Callback<ItemDetailsResponse>() {
            @Override
            public void onResponse(@NotNull Call<ItemDetailsResponse> call, @NotNull Response<ItemDetailsResponse> response) {
                if (response.isSuccessful()) {
                    progressbarObservable.setValue(false);
                    homeData.setValue(response.body());
                } else {
                    progressbarObservable.setValue(false);
                    toastMessageObserver.setValue("Something unexpected happened to our request: " + response.message()); // Whenever you want to show toast use setValue.

                }
            }

            @Override
            public void onFailure(@NotNull Call<ItemDetailsResponse> call, @NotNull Throwable t) {
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

    // getting cart insert data response
    public MutableLiveData<CartResponse> getCartInsertData(JsonObject jsonObject) {
        progressbarObservable.setValue(true);
        MutableLiveData<CartResponse> homeData = new MutableLiveData<>();
        newsApiInterface.getCartInsertList(jsonObject).enqueue(new Callback<CartResponse>() {
            @Override
            public void onResponse(@NotNull Call<CartResponse> call, @NotNull Response<CartResponse> response) {
                if (response.isSuccessful()) {
                    progressbarObservable.setValue(false);
                    homeData.setValue(response.body());
                } else {
                    progressbarObservable.setValue(false);
                    toastMessageObserver.setValue("Something unexpected happened to our request: " + response.message()); // Whenever you want to show toast use setValue.

                }
            }

            @Override
            public void onFailure(@NotNull Call<CartResponse> call, @NotNull Throwable t) {
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

    // getting cart update data response
    public MutableLiveData<CartResponse> getCartUpdateData(JsonObject jsonObject) {
        progressbarObservable.setValue(true);
        MutableLiveData<CartResponse> homeData = new MutableLiveData<>();
        newsApiInterface.getCartUpdateList(jsonObject).enqueue(new Callback<CartResponse>() {
            @Override
            public void onResponse(@NotNull Call<CartResponse> call, @NotNull Response<CartResponse> response) {
                if (response.isSuccessful()) {
                    progressbarObservable.setValue(false);
                    homeData.setValue(response.body());
                } else {
                    progressbarObservable.setValue(false);
                    toastMessageObserver.setValue("Something unexpected happened to our request: " + response.message()); // Whenever you want to show toast use setValue.

                }
            }

            @Override
            public void onFailure(@NotNull Call<CartResponse> call, @NotNull Throwable t) {
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

    // getting view cart data response
    public MutableLiveData<CartResponse> getCartViewData(JsonObject jsonObject) {
        progressbarObservable.setValue(true);
        MutableLiveData<CartResponse> homeData = new MutableLiveData<>();
        newsApiInterface.getCartViewList(jsonObject).enqueue(new Callback<CartResponse>() {
            @Override
            public void onResponse(@NotNull Call<CartResponse> call, @NotNull Response<CartResponse> response) {
                if (response.isSuccessful()) {
                    progressbarObservable.setValue(false);
                    homeData.setValue(response.body());
                } else {
                    progressbarObservable.setValue(false);
                    toastMessageObserver.setValue("Something unexpected happened to our request: " + response.message()); // Whenever you want to show toast use setValue.

                }
            }

            @Override
            public void onFailure(@NotNull Call<CartResponse> call, @NotNull Throwable t) {
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

    // getting place order data response
    public MutableLiveData<PlaceOrderResponse> getPlaceOrderData(JsonObject jsonObject) {
        progressbarObservable.setValue(true);
        MutableLiveData<PlaceOrderResponse> homeData = new MutableLiveData<>();
        newsApiInterface.getPlaceOrderList(jsonObject).enqueue(new Callback<PlaceOrderResponse>() {
            @Override
            public void onResponse(@NotNull Call<PlaceOrderResponse> call, @NotNull Response<PlaceOrderResponse> response) {
                if (response.isSuccessful()) {
                    progressbarObservable.setValue(false);
                    homeData.setValue(response.body());
                } else {
                    progressbarObservable.setValue(false);
                    toastMessageObserver.setValue("Something unexpected happened to our request: " + response.message()); // Whenever you want to show toast use setValue.

                }
            }

            @Override
            public void onFailure(@NotNull Call<PlaceOrderResponse> call, @NotNull Throwable t) {
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

    // getting shops data response
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

    // getting address data response
    public MutableLiveData<AddressResponse> getAddressData(JsonObject jsonObject) {
        progressbarObservable.setValue(true);
        MutableLiveData<AddressResponse> homeData = new MutableLiveData<>();

        newsApiInterface.getAddressList(jsonObject).enqueue(new Callback<AddressResponse>() {
            @Override
            public void onResponse(@NotNull Call<AddressResponse> call, @NotNull Response<AddressResponse> response) {
                if (response.isSuccessful()) {
                    progressbarObservable.setValue(false);
                    homeData.setValue(response.body());
                } else {
                    progressbarObservable.setValue(false);
                    toastMessageObserver.setValue("Something unexpected happened to our request: " + response.message()); // Whenever you want to show toast use setValue.

                }
            }

            @Override
            public void onFailure(@NotNull Call<AddressResponse> call, @NotNull Throwable t) {
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

    // getting address data response
    public MutableLiveData<AddressResponse> getInsertAddressData(JsonObject jsonObject) {
        progressbarObservable.setValue(true);
        MutableLiveData<AddressResponse> homeData = new MutableLiveData<>();

        newsApiInterface.getAddressInsertList(jsonObject).enqueue(new Callback<AddressResponse>() {
            @Override
            public void onResponse(@NotNull Call<AddressResponse> call, @NotNull Response<AddressResponse> response) {
                if (response.isSuccessful()) {
                    progressbarObservable.setValue(false);
                    homeData.setValue(response.body());
                } else {
                    progressbarObservable.setValue(false);
                    toastMessageObserver.setValue("Something unexpected happened to our request: " + response.message()); // Whenever you want to show toast use setValue.

                }
            }

            @Override
            public void onFailure(@NotNull Call<AddressResponse> call, @NotNull Throwable t) {
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

    // getting address data response
    public MutableLiveData<AddressResponse> getUpdateAddressData(JsonObject jsonObject) {
        progressbarObservable.setValue(true);
        MutableLiveData<AddressResponse> homeData = new MutableLiveData<>();

        newsApiInterface.getAddressUpdateList(jsonObject).enqueue(new Callback<AddressResponse>() {
            @Override
            public void onResponse(@NotNull Call<AddressResponse> call, @NotNull Response<AddressResponse> response) {
                if (response.isSuccessful()) {
                    progressbarObservable.setValue(false);
                    homeData.setValue(response.body());
                } else {
                    progressbarObservable.setValue(false);
                    toastMessageObserver.setValue("Something unexpected happened to our request: " + response.message()); // Whenever you want to show toast use setValue.

                }
            }

            @Override
            public void onFailure(@NotNull Call<AddressResponse> call, @NotNull Throwable t) {
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

    // getting address data response
    public MutableLiveData<AddressResponse> getDeleteAddressData(JsonObject jsonObject) {
        progressbarObservable.setValue(true);
        MutableLiveData<AddressResponse> homeData = new MutableLiveData<>();

        newsApiInterface.getAddressDeleteList(jsonObject).enqueue(new Callback<AddressResponse>() {
            @Override
            public void onResponse(@NotNull Call<AddressResponse> call, @NotNull Response<AddressResponse> response) {
                if (response.isSuccessful()) {
                    progressbarObservable.setValue(false);
                    homeData.setValue(response.body());
                } else {
                    progressbarObservable.setValue(false);
                    toastMessageObserver.setValue("Something unexpected happened to our request: " + response.message()); // Whenever you want to show toast use setValue.

                }
            }

            @Override
            public void onFailure(@NotNull Call<AddressResponse> call, @NotNull Throwable t) {
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

    // getting order history data response
    public MutableLiveData<OrderHistoryResponse> getOrderHistoryData(JsonObject jsonObject) {
        progressbarObservable.setValue(true);
        MutableLiveData<OrderHistoryResponse> homeData = new MutableLiveData<>();

        newsApiInterface.getOrderHistoryList(jsonObject).enqueue(new Callback<OrderHistoryResponse>() {
            @Override
            public void onResponse(@NotNull Call<OrderHistoryResponse> call, @NotNull Response<OrderHistoryResponse> response) {
                if (response.isSuccessful()) {

                    progressbarObservable.setValue(false);
                    homeData.setValue(response.body());
                } else {
                    progressbarObservable.setValue(false);
                    toastMessageObserver.setValue("Something unexpected happened to our request: " + response.message()); // Whenever you want to show toast use setValue.

                }
            }

            @Override
            public void onFailure(@NotNull Call<OrderHistoryResponse> call, @NotNull Throwable t) {
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

    // getting categories data response
    public MutableLiveData<CategoriesResponse> getCategoriesData(JsonObject jsonObject) {
        progressbarObservable.setValue(true);
        MutableLiveData<CategoriesResponse> homeData = new MutableLiveData<>();

        newsApiInterface.getCategoriesList(jsonObject).enqueue(new Callback<CategoriesResponse>() {
            @Override
            public void onResponse(@NotNull Call<CategoriesResponse> call, @NotNull Response<CategoriesResponse> response) {
                if (response.isSuccessful()) {
                    progressbarObservable.setValue(false);
                    homeData.setValue(response.body());
                } else {
                    progressbarObservable.setValue(false);
                    toastMessageObserver.setValue("Something unexpected happened to our request: " + response.message()); // Whenever you want to show toast use setValue.

                }
            }

            @Override
            public void onFailure(@NotNull Call<CategoriesResponse> call, @NotNull Throwable t) {
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

    // getting cities data response
    public MutableLiveData<CitiesResponse> getCitiesData(JsonObject jsonObject) {
        progressbarObservable.setValue(true);
        MutableLiveData<CitiesResponse> homeData = new MutableLiveData<>();

        newsApiInterface.getCitiesList(jsonObject).enqueue(new Callback<CitiesResponse>() {
            @Override
            public void onResponse(@NotNull Call<CitiesResponse> call, @NotNull Response<CitiesResponse> response) {
                if (response.isSuccessful()) {
                    progressbarObservable.setValue(false);
                    homeData.setValue(response.body());
                } else {
                    progressbarObservable.setValue(false);
                    toastMessageObserver.setValue("Something unexpected happened to our request: " + response.message()); // Whenever you want to show toast use setValue.

                }
            }

            @Override
            public void onFailure(@NotNull Call<CitiesResponse> call, @NotNull Throwable t) {
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
