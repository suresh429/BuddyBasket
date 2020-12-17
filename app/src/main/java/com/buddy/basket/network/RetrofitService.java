package com.buddy.basket.network;

import android.content.Context;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
   public static String IMAGE_HOME_URL ="https://www.buddybasket.in/public/";

   public static Retrofit retrofit = null;

    public static <S> S createService(Class<S> serviceClass,Context context) {
        if (retrofit == null) {

            OkHttpClient.Builder oktHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new NetworkConnectionInterceptor(context));
            // Adding NetworkConnectionInterceptor with okHttpClientBuilder.

            retrofit = new Retrofit.Builder()
                    .baseUrl("https://www.buddybasket.in/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(oktHttpClient.build())
                    .build();

        }
        return retrofit.create(serviceClass);
    }
}
