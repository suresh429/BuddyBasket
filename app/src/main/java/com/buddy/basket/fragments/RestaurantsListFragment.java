package com.buddy.basket.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.buddy.basket.adapters.RestaurantsListAdapter;
import com.buddy.basket.databinding.FragmentRestaurantsBinding;
import com.buddy.basket.helper.utils;
import com.buddy.basket.model.RestaurantListResponse;
import com.buddy.basket.viewmodels.RestaurantsViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;


public class RestaurantsListFragment extends Fragment {


    ArrayList<RestaurantListResponse.DataBean> dataBeanArrayList = new ArrayList<>();

    RestaurantsViewModel restaurantsViewModel;
    FragmentRestaurantsBinding binding;
    RestaurantsListAdapter restaurantsListAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        restaurantsViewModel = new ViewModelProvider(this).get(RestaurantsViewModel.class);
        //View root = inflater.inflate(R.layout.fragment_restaurants, container, false);
        binding = FragmentRestaurantsBinding.inflate(inflater,container,false);

        restaurantsViewModel.init("Kakinada","Jayendra Nagar",requireActivity());

        // Alert toast msg
        restaurantsViewModel.getToastObserver().observe(getViewLifecycleOwner(), message -> {
            // Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            Snackbar snackbar = Snackbar.make(binding.getRoot().getRootView(), message, Snackbar.LENGTH_LONG);
            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(Color.BLACK);
            snackbar.show();

            utils.noNetworkAlert(getActivity(),message);


        });


        // progress bar
        restaurantsViewModel.getProgressbarObservable().observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean){
                binding.progressBar.setVisibility(View.VISIBLE);

            }else {
                binding.progressBar.setVisibility(View.GONE);

            }
        });


        // get home data
        restaurantsViewModel.getRepository().observe(getViewLifecycleOwner(), homeResponse -> {
            List<RestaurantListResponse.DataBean> catDetailsBeanList = homeResponse.getData();

            dataBeanArrayList.addAll(catDetailsBeanList);

            restaurantsListAdapter = new RestaurantsListAdapter(catDetailsBeanList,getActivity());
            binding.recyclerHomeList.setAdapter(restaurantsListAdapter);



            binding.progressBar.setVisibility(View.GONE);

            restaurantsListAdapter.notifyDataSetChanged();

        });




        return binding.getRoot();
    }
}