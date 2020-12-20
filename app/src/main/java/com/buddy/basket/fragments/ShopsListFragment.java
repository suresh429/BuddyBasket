package com.buddy.basket.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.buddy.basket.adapters.ShopsListAdapter;
import com.buddy.basket.databinding.FragmentShopsNamesBinding;
import com.buddy.basket.helper.utils;
import com.buddy.basket.model.ShopsListResponse;
import com.buddy.basket.viewmodels.ShopsViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;


public class ShopsListFragment extends Fragment {


    ArrayList<ShopsListResponse.DataBean> dataBeanArrayList = new ArrayList<>();

    ShopsViewModel shopsViewModel;
    FragmentShopsNamesBinding binding;
    ShopsListAdapter shopsListAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shopsViewModel = new ViewModelProvider(this).get(ShopsViewModel.class);
        //View root = inflater.inflate(R.layout.fragment_restaurants, container, false);
        binding = FragmentShopsNamesBinding.inflate(inflater,container,false);

        shopsViewModel.initShops("Kakinada","Jayendra Nagar",requireActivity());

        // Alert toast msg
        shopsViewModel.getToastObserver().observe(getViewLifecycleOwner(), message -> {
            // Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            Snackbar snackbar = Snackbar.make(binding.getRoot().getRootView(), message, Snackbar.LENGTH_LONG);
            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(Color.BLACK);
            snackbar.show();

            utils.noNetworkAlert(getActivity(),message);


        });


        // progress bar
        shopsViewModel.getProgressbarObservable().observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean){
                binding.progressBar.setVisibility(View.VISIBLE);

            }else {
                binding.progressBar.setVisibility(View.GONE);

            }
        });


        // get home data
        shopsViewModel.getRepository().observe(getViewLifecycleOwner(), homeResponse -> {
            List<ShopsListResponse.DataBean> catDetailsBeanList = homeResponse.getData();

            dataBeanArrayList.addAll(catDetailsBeanList);

            shopsListAdapter = new ShopsListAdapter(catDetailsBeanList,getActivity());
            binding.recyclerHomeList.setAdapter(shopsListAdapter);



            binding.progressBar.setVisibility(View.GONE);

            shopsListAdapter.notifyDataSetChanged();

        });




        return binding.getRoot();
    }
}