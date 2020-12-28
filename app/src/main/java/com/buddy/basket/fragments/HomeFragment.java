package com.buddy.basket.fragments;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.buddy.basket.R;
import com.buddy.basket.activities.HomeActivity;
import com.buddy.basket.adapters.CategoryListAdapter;
import com.buddy.basket.adapters.LocationListAdapter;

import com.buddy.basket.adapters.ShopsListAdapter;
import com.buddy.basket.databinding.FragmentHomeBinding;
import com.buddy.basket.databinding.FragmentShopsNamesBinding;
import com.buddy.basket.helper.UserSessionManager;
import com.buddy.basket.helper.Util;
import com.buddy.basket.model.CategoriesResponse;
import com.buddy.basket.model.CitiesResponse;
import com.buddy.basket.model.ShopsListResponse;
import com.buddy.basket.viewmodels.CategoriesViewModel;
import com.buddy.basket.viewmodels.CitiesViewModel;
import com.buddy.basket.viewmodels.ShopsViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kotlin.collections.CollectionsKt;


public class HomeFragment extends Fragment implements View.OnClickListener, LocationListAdapter.AdapterListner {
   UserSessionManager userSessionManager;
    AlertDialog alertDialog ;
    private static final String TAG = "CatList";
    ArrayList<CategoriesResponse.DataBean> dataBeanArrayList = new ArrayList<>();

    CategoriesViewModel categoriesViewModel;
    CitiesViewModel citiesViewModel;

    FragmentHomeBinding binding;
    CategoryListAdapter categoryListAdapter;
    String city_Name;
    String cityId;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        citiesViewModel = new ViewModelProvider(this).get(CitiesViewModel.class);
        categoriesViewModel = new ViewModelProvider(this).get(CategoriesViewModel.class);

        //View root = inflater.inflate(R.layout.fragment_restaurants, container, false);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        userSessionManager= new UserSessionManager(requireContext());
        HashMap<String , String> location = userSessionManager.getLocationDetails();
        cityId = location.get("cityId");
        city_Name =  location.get("cityName");

        Log.d(TAG, "onCreateView: "+ cityId + "======"+city_Name);
        //binding.actionLayout.textLocation.setText(city_Name);
        binding.actionLayout.textLocation.setOnClickListener(this);
        binding.actionLayout.badgeCart.setOnClickListener(this);


        citiesList();
        homeData();
       /* ((HomeActivity) requireActivity()).cartCount();*/


        return binding.getRoot();
    }

    private void citiesList() {

        citiesViewModel.initCities("1", requireActivity());

        // Alert toast msg
        citiesViewModel.getToastObserver().observe(getViewLifecycleOwner(), message -> {
            // Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            Snackbar snackbar = Snackbar.make(binding.getRoot().getRootView(), message, Snackbar.LENGTH_LONG);
            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(Color.BLACK);
            snackbar.show();

            Util.noNetworkAlert(getActivity(), message);


        });


        // progress bar
        citiesViewModel.getProgressbarObservable().observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                binding.progressBar.setVisibility(View.VISIBLE);

            } else {
                binding.progressBar.setVisibility(View.GONE);

            }
        });


        // get home data
        citiesViewModel.getRepository().observe(getViewLifecycleOwner(), homeResponse -> {
            if (homeResponse.getStatus().equalsIgnoreCase("true")){
                List<CitiesResponse.DataBean> dataBeans = homeResponse.getData();



                if (cityId!=null && city_Name != null){

                    binding.actionLayout.textLocation.setText(city_Name);

                }else {
                    userSessionManager.saveLocation(String.valueOf(dataBeans.get(0).getId()),dataBeans.get(0).getCity());
                    binding.actionLayout.textLocation.setText(dataBeans.get(0).getCity());

                }

                Log.d(TAG, "inside method: "+ cityId + "======"+dataBeans.get(0).getCity());

                //before inflating the custom alert dialog layout, we will get the current activity viewgroup
                ViewGroup viewGroup = getView().getRootView().findViewById(android.R.id.content);

                //then we will inflate the custom alert dialog xml that we created
                View dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.my_location_lis_dialog, viewGroup, false);

                //Now we need an AlertDialog.Builder object
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(requireContext());

                //setting the view of the builder to our custom view that we already inflated
                builder.setView(dialogView);

                //finally creating the alert dialog and displaying it
                alertDialog = builder.create();
                alertDialog.setCancelable(true);
                //alertDialog.show();


                RecyclerView recyclerView = dialogView.findViewById(R.id.locationRecycler);
                RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(mLayoutManager1);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.addItemDecoration(new DividerItemDecoration(this.getActivity(), LinearLayout.VERTICAL));


                LocationListAdapter adapter = new LocationListAdapter(dataBeans, requireContext(),this::onClick);
                recyclerView.setAdapter(adapter);


                binding.progressBar.setVisibility(View.GONE);

                //shopsListAdapter.notifyDataSetChanged();
            }else {
                Util.snackBar(getView().getRootView(),"No Locations Found!",Color.RED);
            }


        });


    }

    private void homeData() {
        categoriesViewModel.initCategories(requireActivity());

        // Alert toast msg
        categoriesViewModel.getToastObserver().observe(getViewLifecycleOwner(), message -> {
            // Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            Snackbar snackbar = Snackbar.make(binding.getRoot().getRootView(), message, Snackbar.LENGTH_LONG);
            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(Color.BLACK);
            snackbar.show();

            Util.noNetworkAlert(getActivity(), message);


        });


        // progress bar
        categoriesViewModel.getProgressbarObservable().observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                binding.progressBar.setVisibility(View.VISIBLE);

            } else {
                binding.progressBar.setVisibility(View.GONE);

            }
        });


        // get home data
        categoriesViewModel.getRepository().observe(getViewLifecycleOwner(), homeResponse -> {
            List<CategoriesResponse.DataBean> catDetailsBeanList = homeResponse.getData();
            dataBeanArrayList.addAll(catDetailsBeanList);

            List<CategoriesResponse.DataBean> filterDataBean = CollectionsKt.filter(catDetailsBeanList, s -> !s.getStatus().equals("0"));

            categoryListAdapter = new CategoryListAdapter(filterDataBean, getActivity());
            binding.recyclerHomeList.setAdapter(categoryListAdapter);

            binding.progressBar.setVisibility(View.GONE);

            categoryListAdapter.notifyDataSetChanged();

        });

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.text_location){
            alertDialog.show();
        }else if (v.getId() == R.id.badge_cart){
            Navigation.findNavController(v).navigate(R.id.navigation_cart);
        }
    }

    @Override
    public void onClick(CitiesResponse.DataBean product) {
        alertDialog.dismiss();
        userSessionManager.saveLocation(String.valueOf(product.getId()),product.getCity());
        binding.actionLayout.textLocation.setText(product.getCity());


    }
}