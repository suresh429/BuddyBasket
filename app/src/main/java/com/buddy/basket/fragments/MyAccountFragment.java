package com.buddy.basket.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.buddy.basket.R;
import com.buddy.basket.databinding.FragmentMyaccountBinding;
import com.buddy.basket.viewmodels.MyAccountViewModel;

import java.util.Objects;


public class MyAccountFragment extends Fragment {
    FragmentMyaccountBinding binding;
    private MyAccountViewModel myAccountViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        myAccountViewModel = new ViewModelProvider(this).get(MyAccountViewModel.class);
        binding = FragmentMyaccountBinding.inflate(inflater, container, false);

        myAccountViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //binding.textNotifications.setText(s);
            }
        });

        return binding.getRoot();
    }
}