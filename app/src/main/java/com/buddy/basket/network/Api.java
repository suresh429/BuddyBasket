package com.buddy.basket.network;

import com.buddy.basket.model.ResItemsListResponse;
import com.buddy.basket.model.RestaurantListResponse;
import com.google.gson.JsonObject;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {

    @Headers("Content-Type: application/json")
    @POST("load_restaurants.php")
    Call<RestaurantListResponse> getRestaurantList(@Body JsonObject jsonObject);

   @Headers("Content-Type: application/json")
    @POST("load_all_items.php")
    Call<ResItemsListResponse> getItemsList(@Body JsonObject jsonObject);





}
