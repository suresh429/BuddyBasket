package com.buddy.basket.activities;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.buddy.basket.R;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },1500);
    }
}