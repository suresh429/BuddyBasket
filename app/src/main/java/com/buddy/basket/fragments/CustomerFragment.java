package com.buddy.basket.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.buddy.basket.databinding.FragmentMyaccountBinding;
import com.buddy.basket.viewmodels.CustomerViewModel;


public class CustomerFragment extends Fragment {
    FragmentMyaccountBinding binding;
    private CustomerViewModel customerViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        customerViewModel = new ViewModelProvider(this).get(CustomerViewModel.class);
        binding = FragmentMyaccountBinding.inflate(inflater, container, false);



        return binding.getRoot();
    }
}