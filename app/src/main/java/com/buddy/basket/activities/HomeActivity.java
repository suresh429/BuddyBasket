package com.buddy.basket.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.buddy.basket.R;
import com.buddy.basket.databinding.ActivityHomeBinding;
import com.buddy.basket.helper.UserSessionManager;
import com.buddy.basket.model.CartResponse;
import com.buddy.basket.network.ApiInterface;
import com.buddy.basket.network.RetrofitService;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.JsonObject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG ="HOME" ;
    BottomNavigationView navView;
    boolean doubleBackToExitPressedOnce = false;
    ActivityHomeBinding binding;
    String customerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
       /* AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_categories, R.id.navigation_myaccount,R.id.navigation_cart)
                .build();*/
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId()==R.id.navigation_home || destination.getId()==R.id.navigation_cart
                    || destination.getId()==R.id.navigation_history || destination.getId()==R.id.navigation_myaccount){
                navView.setVisibility(View.VISIBLE);
                cartCount();
            }else {
                navView.setVisibility(View.GONE);

            }
        });

        UserSessionManager userSessionManager = new UserSessionManager(HomeActivity.this);
        HashMap<String, String> userDetails = userSessionManager.getUserDetails();
        customerId = userDetails.get("id");



    }

    @Override
    protected void onStart() {
        super.onStart();

        cartCount();
    }

   /* @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }*/

    public void cartCount(){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("customer_id", customerId);
        Call<CartResponse> call = RetrofitService.createService(ApiInterface.class, HomeActivity.this).getCartViewList(jsonObject);
        call.enqueue(new Callback<CartResponse>() {
            @Override
            public void onResponse(@NonNull Call<CartResponse> call, @NonNull Response<CartResponse> response) {

                if (response.isSuccessful()) {

                    assert response.body() != null;
                    if (response.body().getStatus().equalsIgnoreCase("true")){

                        List<CartResponse.CartBean> cartBeanList = response.body().getCart();
                        BadgeDrawable badgeDrawable = binding.navView.getOrCreateBadge(R.id.navigation_cart);
                        badgeDrawable.setBackgroundColor(Color.parseColor("#FB4249"));
                        badgeDrawable.setBadgeTextColor(Color.WHITE);
                        badgeDrawable.setMaxCharacterCount(3);
                        badgeDrawable.setNumber(cartBeanList.size());

                    }else {
                        binding.navView.removeBadge(R.id.navigation_cart);
                    }



                }
            }

            @Override
            public void onFailure(@NonNull Call<CartResponse> call, @NonNull Throwable t) {
                //Toast.makeText(HomeActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
               binding.noInternet.noInternet.setVisibility(View.VISIBLE);
               binding.navView.setVisibility(View.GONE);

            }
        });
    }





}