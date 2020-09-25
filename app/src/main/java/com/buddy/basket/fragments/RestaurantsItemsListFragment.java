package com.buddy.basket.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Constraints;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.buddy.basket.R;
import com.buddy.basket.activities.HomeActivity;
import com.buddy.basket.adapters.RestaurantsItemsListAdapter;
import com.buddy.basket.adapters.RestaurantsListAdapter;
import com.buddy.basket.databinding.FragmentRestaurantsBinding;
import com.buddy.basket.databinding.FragmentRestaurantsItemsListBinding;
import com.buddy.basket.helper.utils;
import com.buddy.basket.model.Product;
import com.buddy.basket.model.ResItemsListResponse;
import com.buddy.basket.model.RestaurantListResponse;
import com.buddy.basket.viewmodels.RestaurantItemsListViewModel;
import com.buddy.basket.viewmodels.RestaurantsViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;


public class RestaurantsItemsListFragment extends Fragment implements RestaurantsItemsListAdapter.RestaurantItemInterface {

    ArrayList<ResItemsListResponse.DataBean> dataBeanArrayList = new ArrayList<>();
    List<Product> productList = new ArrayList<>();

    RestaurantItemsListViewModel restaurantsViewModel;
    FragmentRestaurantsItemsListBinding binding;
    RestaurantsItemsListAdapter restaurantsListAdapter;

    String id,name,type,address,time;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        restaurantsViewModel = new ViewModelProvider(this).get(RestaurantItemsListViewModel.class);
        //View root = inflater.inflate(R.layout.fragment_restaurants, container, false);
        binding = FragmentRestaurantsItemsListBinding.inflate(inflater,container,false);

        //hideBottomNav();

        Bundle bundle=getArguments();
        assert bundle != null;
        id=bundle.getString("id");
        name=bundle.getString("name");
        type=bundle.getString("type");
        address=bundle.getString("address");
        time=bundle.getString("time");

        // init
        restaurantsViewModel.init(id,requireActivity());


        binding.txtRestaruantName.setText(name);
        binding.txtAddreess.setText(address);
        binding.txtAvgPrepTime.setText(time);
        binding.txtKnownFor.setText(type);

        binding.actionLayout.txtActionBarTitle.setText("Menu");
        binding.actionLayout.badgeCart.setVisibility(View.GONE);
        binding.actionLayout.txtActionBarTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).popBackStack();
            }
        });
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
            List<ResItemsListResponse.DataBean> catDetailsBeanList = homeResponse.getData();

            dataBeanArrayList.addAll(catDetailsBeanList);
            for (ResItemsListResponse.DataBean product : catDetailsBeanList){
                productList.add(new Product(product.getItem_ID(),product.getItem_Name(),product.getCategory(),product.getType(),product.getImgUrl(),Double.parseDouble(product.getItem_Price()),0));
            }


            restaurantsListAdapter = new RestaurantsItemsListAdapter(productList,getActivity(),this);
            binding.recyclerHomeList.setAdapter(restaurantsListAdapter);



            binding.progressBar.setVisibility(View.GONE);

            restaurantsListAdapter.notifyDataSetChanged();

        });




        return binding.getRoot();
    }

    @Override
    public void onMinusClick(int position, Product product) {
        int i = productList.indexOf(product);
        Log.d(TAG, "onMinusClick: "+product.getQty());
        if (product.getQty() > 0) {

            Product updatedProduct = new Product(
                    product.getId(), product.getPdtName(), product.getCategory(), product.getType(),product.getImage(),
                    product.getPrice(),
                    (product.getQty() - 1)
            );

            productList.remove(product);
            productList.add(i, updatedProduct);

            restaurantsListAdapter.notifyDataSetChanged();
            Log.d(TAG, "onMinusClick1: "+product.getQty());

            calculateCartTotal();
        }

    }

    @Override
    public void onPlusClick(int position, Product product) {
        int i = productList.indexOf(product);
        Product updatedProduct = new Product(
                product.getId(), product.getPdtName(), product.getCategory(), product.getType(),product.getImage(),
                product.getPrice(),
                (product.getQty() + 1)
        );

        productList.remove(product);
        productList.add(i, updatedProduct);

        restaurantsListAdapter.notifyDataSetChanged();
        calculateCartTotal();
    }

    @Override
    public void onAddClick(int position, Product product) {
        int i = productList.indexOf(product);
        Product updatedProduct = new Product(
                product.getId(), product.getPdtName(), product.getCategory(), product.getType(),product.getImage(),
                product.getPrice(),
                1
        );

        productList.remove(product);
        productList.add(i, updatedProduct);
        restaurantsListAdapter.notifyDataSetChanged();
        calculateCartTotal();
    }

    // total Amount
    public void calculateCartTotal() {

        int grandTotal = 0;
        int itemCount = 0;
        for (Product order : productList) {

            grandTotal += order.getPrice() * order.getQty();

            if (order.getQty() > 0) {
                itemCount += order.getQty();
            }
        }

        if (grandTotal != 0) {
            binding.actionBottomCart.txtItemPrice.setText("\u20B9 " + grandTotal);
            binding.actionBottomCart.txtItemCount.setText(itemCount +" ITEMS");
            binding.actionBottomCart.getRoot().setVisibility(View.VISIBLE);
        } else {
            binding.actionBottomCart.getRoot().setVisibility(View.GONE);
        }

       /* btnAddtocart.setOnClickListener(view -> {

            if (btnAddtocart.getText().toString().equalsIgnoreCase("GOTO CART")){
                Intent intent = new Intent(ProductsActivity.this,HomeActivity.class);
                intent.putExtra(BOTTAM_TAB_POSITION,2);
                startActivity(intent);
            }else {
                addToCart(cartArray);
            }

        });*/


    }
}