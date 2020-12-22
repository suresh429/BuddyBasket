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

import com.buddy.basket.adapters.ItemsListAdapter;


import com.buddy.basket.databinding.FragmentItemsListBinding;
import com.buddy.basket.helper.Util;
import com.buddy.basket.model.ItemDetailsResponse;
import com.buddy.basket.model.ItemsListResponse;
import com.buddy.basket.viewmodels.ItemsListViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;


public class ItemsListFragment extends Fragment {

    ArrayList<ItemsListResponse.DataBean> dataBeanArrayList = new ArrayList<>();
    List<ItemDetailsResponse> itemDetailsResponseList = new ArrayList<>();

    ItemsListViewModel restaurantsViewModel;
    FragmentItemsListBinding binding;
    ItemsListAdapter restaurantsListAdapter;

    String name,type,address,time;
    int id;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        restaurantsViewModel = new ViewModelProvider(this).get(ItemsListViewModel.class);
        //View root = inflater.inflate(R.layout.fragment_restaurants, container, false);
        binding = FragmentItemsListBinding.inflate(inflater,container,false);

        //hideBottomNav();

        Bundle bundle=getArguments();
        assert bundle != null;
        id=bundle.getInt("id");
        name=bundle.getString("name");

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

            Util.noNetworkAlert(getActivity(),message);


        });


        // progress bar
        restaurantsViewModel.getProgressbarObservable().observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean){
                binding.progressBar.setVisibility(View.VISIBLE);

            }else {
                binding.progressBar.setVisibility(View.GONE);

            }
        });


       /* // get home data
        restaurantsViewModel.getRepository().observe(getViewLifecycleOwner(), homeResponse -> {
            List<ItemsListResponse.DataBean> catDetailsBeanList = homeResponse.getData();

            dataBeanArrayList.addAll(catDetailsBeanList);
            for (ItemsListResponse.DataBean product : catDetailsBeanList){
                itemDetailsResponseList.add(new ItemDetailsResponse(product.getItem_ID(),product.getItem_Name(),product.getCategory(),product.getType(),product.getImgUrl(),Double.parseDouble(product.getItem_Price()),0));
            }


            restaurantsListAdapter = new ItemsListAdapter(itemDetailsResponseList,getActivity(),this);
            binding.recyclerHomeList.setAdapter(restaurantsListAdapter);



            binding.progressBar.setVisibility(View.GONE);

            restaurantsListAdapter.notifyDataSetChanged();

        });*/




        return binding.getRoot();
    }

   /* @Override
    public void onMinusClick(int position, ItemDetailsResponse itemDetailsResponse) {
        int i = itemDetailsResponseList.indexOf(itemDetailsResponse);
        Log.d(TAG, "onMinusClick: "+ itemDetailsResponse.getQty());
        if (itemDetailsResponse.getQty() > 0) {

            ItemDetailsResponse updatedItemDetailsResponse = new ItemDetailsResponse(
                    itemDetailsResponse.getId(), itemDetailsResponse.getPdtName(), itemDetailsResponse.getCategory(), itemDetailsResponse.getType(), itemDetailsResponse.getImage(),
                    itemDetailsResponse.getPrice(),
                    (itemDetailsResponse.getQty() - 1)
            );

            itemDetailsResponseList.remove(itemDetailsResponse);
            itemDetailsResponseList.add(i, updatedItemDetailsResponse);

            restaurantsListAdapter.notifyDataSetChanged();
            Log.d(TAG, "onMinusClick1: "+ itemDetailsResponse.getQty());

            calculateCartTotal();
        }

    }

    @Override
    public void onPlusClick(int position, ItemDetailsResponse itemDetailsResponse) {
        int i = itemDetailsResponseList.indexOf(itemDetailsResponse);
        ItemDetailsResponse updatedItemDetailsResponse = new ItemDetailsResponse(
                itemDetailsResponse.getId(), itemDetailsResponse.getPdtName(), itemDetailsResponse.getCategory(), itemDetailsResponse.getType(), itemDetailsResponse.getImage(),
                itemDetailsResponse.getPrice(),
                (itemDetailsResponse.getQty() + 1)
        );

        itemDetailsResponseList.remove(itemDetailsResponse);
        itemDetailsResponseList.add(i, updatedItemDetailsResponse);

        restaurantsListAdapter.notifyDataSetChanged();
        calculateCartTotal();
    }

    @Override
    public void onAddClick(int position, ItemDetailsResponse itemDetailsResponse) {
        int i = itemDetailsResponseList.indexOf(itemDetailsResponse);
        ItemDetailsResponse updatedItemDetailsResponse = new ItemDetailsResponse(
                itemDetailsResponse.getId(), itemDetailsResponse.getPdtName(), itemDetailsResponse.getCategory(), itemDetailsResponse.getType(), itemDetailsResponse.getImage(),
                itemDetailsResponse.getPrice(),
                1
        );

        itemDetailsResponseList.remove(itemDetailsResponse);
        itemDetailsResponseList.add(i, updatedItemDetailsResponse);
        restaurantsListAdapter.notifyDataSetChanged();
        calculateCartTotal();
    }

    // total Amount
    public void calculateCartTotal() {

        int grandTotal = 0;
        int itemCount = 0;
        for (ItemDetailsResponse order : itemDetailsResponseList) {

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

       *//* btnAddtocart.setOnClickListener(view -> {

            if (btnAddtocart.getText().toString().equalsIgnoreCase("GOTO CART")){
                Intent intent = new Intent(ProductsActivity.this,HomeActivity.class);
                intent.putExtra(BOTTAM_TAB_POSITION,2);
                startActivity(intent);
            }else {
                addToCart(cartArray);
            }

        });*//*


    }*/
}