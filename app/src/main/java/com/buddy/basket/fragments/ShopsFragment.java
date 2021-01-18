package com.buddy.basket.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.buddy.basket.R;
import com.buddy.basket.adapters.ShopsListAdapter;
import com.buddy.basket.databinding.FragmentShopsNamesBinding;
import com.buddy.basket.helper.UserSessionManager;
import com.buddy.basket.helper.Util;
import com.buddy.basket.model.ShopsListResponse;
import com.buddy.basket.viewmodels.ShopsViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import kotlin.collections.CollectionsKt;


public class ShopsFragment extends Fragment {

    private ShopsViewModel shopsViewModel;
    ArrayList<ShopsListResponse.DataBean> dataBeanArrayList = new ArrayList<>();
    FragmentShopsNamesBinding binding;
    String cityId;
    String city_Name;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shopsViewModel = new ViewModelProvider(this).get(ShopsViewModel.class);
        binding = FragmentShopsNamesBinding.inflate(inflater, container, false);


        UserSessionManager userSessionManager = new UserSessionManager(requireContext());
        HashMap<String, String> location = userSessionManager.getLocationDetails();
        cityId = location.get("cityId");
        city_Name = location.get("cityName");

        Bundle bundle = getArguments();
        assert bundle != null;
        int category_id = bundle.getInt("category_id");
        String categoryName = bundle.getString("categoryname");

        // binding.actionLayout.txtActionBarTitle.setText("Shops");
        binding.actionLayout.txtActionBarTitle.setText(categoryName);
        binding.actionLayout.badgeCart.setVisibility(View.GONE);
        binding.actionLayout.txtActionBarTitle.setOnClickListener(v -> Navigation.findNavController(v).popBackStack());

        shopList(Integer.parseInt(cityId), category_id, categoryName);

        return binding.getRoot();
    }

    private void shopList(int city_id, int category_id, String categoryName) {
        shopsViewModel.initShops(city_id, category_id, requireActivity());

        // Alert toast msg
        shopsViewModel.getToastObserver().observe(getViewLifecycleOwner(), message -> {
            if (message.equalsIgnoreCase(getResources().getString(R.string.no_connection))) {
                binding.noInternet.noInternet.setVisibility(View.VISIBLE);
            } else {
                Util.snackBar(requireView().getRootView(), message, Color.RED);
            }


        });


        // progress bar
        shopsViewModel.getProgressbarObservable().observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                binding.progressBar.setVisibility(View.VISIBLE);

            } else {
                binding.progressBar.setVisibility(View.GONE);

            }
        });


        // get data
        shopsViewModel.getRepository().observe(getViewLifecycleOwner(), homeResponse -> {

            if (homeResponse.getStatus().equalsIgnoreCase("true")) {
                List<ShopsListResponse.DataBean> catDetailsBeanList = homeResponse.getData();
                dataBeanArrayList.addAll(catDetailsBeanList);
                List<ShopsListResponse.DataBean> filterDataBean = CollectionsKt.filter(catDetailsBeanList, s -> !s.getStatus().equals("0"));

                ShopsListAdapter shopsListAdapter = new ShopsListAdapter(filterDataBean, getActivity());
                binding.recyclerShopList.setAdapter(shopsListAdapter);
                shopsListAdapter.notifyDataSetChanged();

                binding.errorLayout.txtError.setVisibility(View.GONE);
                binding.noInternet.noInternet.setVisibility(View.GONE);
            } else {
                binding.errorLayout.txtError.setVisibility(View.VISIBLE);
                binding.noInternet.noInternet.setVisibility(View.GONE);
                binding.recyclerShopList.setVisibility(View.GONE);

            }


        });

    }
}