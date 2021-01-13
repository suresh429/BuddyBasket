package com.buddy.basket.network;

import android.content.Context;

import com.buddy.basket.fragments.ItemsListFragment;
import com.buddy.basket.model.ItemsListResponse;
import com.buddy.basket.model.ResponseWrapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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


            oktHttpClient.addInterceptor(new Interceptor() {
                @NotNull
                @Override
                public Response intercept(@NotNull Chain chain) throws IOException {
                    Request original = chain.request();
                    HttpUrl originalHttpUrl = original.url();

                    HttpUrl url = originalHttpUrl.newBuilder()
                            .addQueryParameter("api_token", "LpDUtnLPfkzzthcCGy06KlU0l8bzD0mSUl8IBWNjRapThL7WFkvyyIvsMRq7")
                            .build();

                    // Request customization: add request headers
                    Request.Builder requestBuilder = original.newBuilder()
                            .url(url);

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });

            retrofit = new Retrofit.Builder()
                    .baseUrl("https://www.buddybasket.in/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(oktHttpClient.build())
                    .build();

        }
        return retrofit.create(serviceClass);
    }


}
