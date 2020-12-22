package com.buddy.basket.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

import com.buddy.basket.R;
import com.buddy.basket.databinding.ActivityLoginBinding;
import com.buddy.basket.helper.UserSessionManager;
import com.buddy.basket.helper.Util;
import com.buddy.basket.viewmodels.CategoriesViewModel;
import com.buddy.basket.viewmodels.CustomerVerifyViewModel;
import com.buddy.basket.viewmodels.CustomerViewModel;

import java.util.Objects;

import static com.buddy.basket.helper.Util.keypadHide;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "LoginActivity";
    ActivityLoginBinding binding;
    CustomerViewModel customerViewModel;
    private UserSessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_login);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // login session
        session = new UserSessionManager(LoginActivity.this);
        if (session.isLoggedIn()) {
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            finish();
        }

       /* binding.btnContinue.setAlpha(.5f);
        binding.btnContinue.setEnabled(false);*/
        binding.etMobile.addTextChangedListener(textWatcher);
        // binding.etPassword.addTextChangedListener(textWatcher);
        binding.btnContinue.setOnClickListener(this);

        customerViewModel = new ViewModelProvider(this).get(CustomerViewModel.class);

    }

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String username = Objects.requireNonNull(binding.etMobile.getText()).toString();

            String value = String.valueOf(s.length());

            if (value.equals("10")) {

                binding.btnContinue.setEnabled(true);
                binding.btnContinue.setAlpha(.9f);
                binding.btnContinue.setText(R.string.continu);
                binding.btnContinue.setClickable(true);

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(binding.etMobile.getWindowToken(), 0);

            } else {
                binding.btnContinue.setAlpha(.5f);
                binding.btnContinue.setEnabled(false);
                binding.btnContinue.setText(R.string.entermobileno);
            }


        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_continue) {
            customer(binding.etMobile.getText().toString());

        }
    }

    private void customer(String mobile) {

        customerViewModel.initCustomer(mobile, this);

        // progress bar
        customerViewModel.getProgressbarObservable().observe(this, aBoolean -> {
            if (aBoolean) {
                binding.progressLayout.progressBar1.setVisibility(View.VISIBLE);

            } else {
                binding.progressLayout.progressBar1.setVisibility(View.GONE);
            }
        });

        // Alert msg
        customerViewModel.getToastObserver().observe(this, message -> {
            if (message.equalsIgnoreCase("401")) {
                // Util.snackBar(binding.getRoot().getRootView(), message, Color.WHITE);
            } else if (message.equalsIgnoreCase("500")) {
                Util.snackBar(binding.getRoot().getRootView(), message, Color.WHITE);
            } else {
                Util.snackBar(binding.getRoot().getRootView(), message, Color.WHITE);
                // noInternetDialog(this);
                //  Util.snackBar(binding.getRoot().getRootView(), "No network available, please check your WiFi or Data connection", Color.WHITE);
            }

        });

        // get  data
        customerViewModel.getRepository().observe(this, baseResponse -> {
            if (baseResponse.getStatus().equalsIgnoreCase("true")) {

                binding.etMobile.setEnabled(false);
                binding.txtInputPassword.setVisibility(View.VISIBLE);
                binding.btnContinue.setEnabled(true);
                binding.btnContinue.setClickable(true);
                binding.btnContinue.setText(R.string.login);

                if (binding.btnContinue.getText().toString().equalsIgnoreCase("LOGIN")) {
                    Log.d(TAG, "customer: " + "hghg");
                    binding.btnContinue.setOnClickListener(v -> verifyCustomer(baseResponse.getCustomer().get(0).getPhonenumber()));
                }


            } else {

                Intent intentLogin = new Intent(LoginActivity.this, RegistrationActivity.class);
                intentLogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                intentLogin.putExtra("mobile", mobile);
                startActivity(intentLogin);
            }

        });

    }

    private void verifyCustomer(String mobile) {
        keypadHide(this);
        String password = binding.etPassword.getText().toString();
        if (password.length() > 5) {
            CustomerVerifyViewModel customerVerifyViewModel = new ViewModelProvider(this).get(CustomerVerifyViewModel.class);

            customerVerifyViewModel.initCustomerVerify(mobile, password, this);

            // progress bar
            customerVerifyViewModel.getProgressbarObservable().observe(this, aBoolean -> {
                if (aBoolean) {
                    binding.progressLayout.progressBar1.setVisibility(View.VISIBLE);

                } else {
                    binding.progressLayout.progressBar1.setVisibility(View.GONE);
                }
            });

            // Alert msg
            customerVerifyViewModel.getToastObserver().observe(this, message -> {
                if (message.equalsIgnoreCase("401")) {
                    // Util.snackBar(binding.getRoot().getRootView(), message, Color.WHITE);
                } else if (message.equalsIgnoreCase("500")) {
                    Util.snackBar(binding.getRoot().getRootView(), message, Color.WHITE);
                } else {
                    Util.snackBar(binding.getRoot().getRootView(), message, Color.WHITE);
                    // noInternetDialog(this);
                    //  Util.snackBar(binding.getRoot().getRootView(), "No network available, please check your WiFi or Data connection", Color.WHITE);
                }

            });

            // get  data
            customerVerifyViewModel.getRepository().observe(this, baseResponse -> {
                if (baseResponse.getStatus().equalsIgnoreCase("true")) {
                    Log.d(TAG, "customer: " + baseResponse.getStatus());

                    // session manager
                    session.createLogin(String.valueOf(baseResponse.getCustomer().get(0).getId()),
                            baseResponse.getCustomer().get(0).getName(),
                            baseResponse.getCustomer().get(0).getPhonenumber());

                    // save device Token
                    // displayFirebaseRegId(baseResponse.getData().getToken());

                    Intent intentLogin = new Intent(LoginActivity.this, HomeActivity.class);
                    intentLogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intentLogin);

                } else {
                    Util.snackBar(binding.getRoot().getRootView(), "Invalid credentials !", Color.WHITE);
                }

            });

        } else {
            Util.snackBar(binding.getRoot().getRootView(), "Password Should be 5 or more characters!", Color.WHITE);
        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}