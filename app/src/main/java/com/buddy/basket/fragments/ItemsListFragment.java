package com.buddy.basket.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.buddy.basket.activities.HomeActivity;
import com.buddy.basket.adapters.ItemsListAdapter;


import com.buddy.basket.databinding.FragmentItemsListBinding;
import com.buddy.basket.helper.UserSessionManager;
import com.buddy.basket.helper.Util;
import com.buddy.basket.model.ItemDetailsResponse;
import com.buddy.basket.model.ItemsListResponse;
import com.buddy.basket.viewmodels.CartViewModel;
import com.buddy.basket.viewmodels.ItemsListViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.content.ContentValues.TAG;


public class ItemsListFragment extends Fragment implements ItemsListAdapter.RestaurantItemInterface {

    ArrayList<ItemsListResponse.DataBean> dataBeanArrayList = new ArrayList<>();
    List<ItemDetailsResponse> itemDetailsResponseList = new ArrayList<>();

    ItemsListViewModel itemsListViewModel;
    CartViewModel cartViewModel ;
    FragmentItemsListBinding binding;
    ItemsListAdapter itemsListAdapter;

    String shopName,customerId;
    int shopId;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //View root = inflater.inflate(R.layout.fragment_restaurants, container, false);
        binding = FragmentItemsListBinding.inflate(inflater, container, false);

        UserSessionManager userSessionManager= new UserSessionManager(requireContext());
        HashMap<String, String> userDetails = userSessionManager.getUserDetails();
        customerId = userDetails.get("id");

        itemsListViewModel = new ViewModelProvider(this).get(ItemsListViewModel.class);
        cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);

        //hideBottomNav();

        Bundle bundle = getArguments();
        assert bundle != null;
        shopId = bundle.getInt("shopId");
        shopName = bundle.getString("shopName");


      /*  binding.txtRestaruantName.setText(name);
        binding.txtAddreess.setText(address);
        binding.txtAvgPrepTime.setText(time);
        binding.txtKnownFor.setText(type);*/

        binding.actionLayout.txtActionBarTitle.setText(shopName);
        binding.actionLayout.badgeCart.setVisibility(View.GONE);
        binding.actionLayout.txtActionBarTitle.setOnClickListener(v -> Navigation.findNavController(v).popBackStack());

        itemsListData();
        return binding.getRoot();
    }

    private void itemsListData() {
        // init
        itemsListViewModel.init(shopId, requireActivity());

        // Alert toast msg
        itemsListViewModel.getToastObserver().observe(getViewLifecycleOwner(), message -> {
            // Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            Snackbar snackbar = Snackbar.make(binding.getRoot().getRootView(), message, Snackbar.LENGTH_LONG);
            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(Color.BLACK);
            snackbar.show();

            Util.noNetworkAlert(getActivity(), message);


        });

        // progress bar
        itemsListViewModel.getProgressbarObservable().observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                binding.progressBar.setVisibility(View.VISIBLE);

            } else {
                binding.progressBar.setVisibility(View.GONE);

            }
        });

        // get home data
        itemsListViewModel.getRepository().observe(getViewLifecycleOwner(), homeResponse -> {

            if (homeResponse.getStatus().equalsIgnoreCase("true")){

                List<ItemsListResponse.DataBean> catDetailsBeanList = homeResponse.getData();
                dataBeanArrayList.addAll(catDetailsBeanList);

                for (ItemsListResponse.DataBean product : catDetailsBeanList) {
                    itemDetailsResponseList.add(new ItemDetailsResponse(product.getId(), product.getItemname(), product.getSlug(), 0, product.getShopId(), product.getCategoryId(),
                            product.getSubcategoryId(),Double.parseDouble(product.getPrice()),product.getDescription(),product.getChoices(),product.getImage(),product.getStatus(),product.getCreatedAt(),product.getUpdatedAt()));
                }

                itemsListAdapter = new ItemsListAdapter(itemDetailsResponseList, getActivity(), this);
                binding.recyclerHomeList.setAdapter(itemsListAdapter);
                binding.progressBar.setVisibility(View.GONE);
                binding.errorLayout.txtError.setVisibility(View.GONE);
                itemsListAdapter.notifyDataSetChanged();

            }else {
                binding.progressBar.setVisibility(View.GONE);
                binding.errorLayout.txtError.setVisibility(View.VISIBLE);
            }


        });

    }


    @Override
    public void onMinusClick(int position, ItemDetailsResponse itemDetailsResponse) {
        int i = itemDetailsResponseList.indexOf(itemDetailsResponse);
        Log.d(TAG, "onMinusClick: "+ itemDetailsResponse.getQty());
        if (itemDetailsResponse.getQty() > 0) {

            ItemDetailsResponse updatedItemDetailsResponse = new ItemDetailsResponse(itemDetailsResponse.getId(), itemDetailsResponse.getItemname(), itemDetailsResponse.getSlug(), (itemDetailsResponse.getQty()-1), itemDetailsResponse.getShop_id(), itemDetailsResponse.getCategory_id(),
                    itemDetailsResponse.getSubcategory_id(),itemDetailsResponse.getPrice(),itemDetailsResponse.getDescription(),itemDetailsResponse.getChoices(),itemDetailsResponse.getImage(),itemDetailsResponse.getStatus(),itemDetailsResponse.getCreated_at(),itemDetailsResponse.getUpdated_at()
            );

            itemDetailsResponseList.remove(itemDetailsResponse);
            itemDetailsResponseList.add(i, updatedItemDetailsResponse);

            itemsListAdapter.notifyDataSetChanged();
            Log.d(TAG, "onMinusClick1: "+ itemDetailsResponse.getQty());

            calculateCartTotal();
        }

    }

    @Override
    public void onPlusClick(int position, ItemDetailsResponse itemDetailsResponse) {
        int i = itemDetailsResponseList.indexOf(itemDetailsResponse);
        ItemDetailsResponse updatedItemDetailsResponse = new ItemDetailsResponse(itemDetailsResponse.getId(), itemDetailsResponse.getItemname(), itemDetailsResponse.getSlug(), (itemDetailsResponse.getQty()+1), itemDetailsResponse.getShop_id(), itemDetailsResponse.getCategory_id(),
                itemDetailsResponse.getSubcategory_id(),itemDetailsResponse.getPrice(),itemDetailsResponse.getDescription(),itemDetailsResponse.getChoices(),itemDetailsResponse.getImage(),itemDetailsResponse.getStatus(),itemDetailsResponse.getCreated_at(),itemDetailsResponse.getUpdated_at()
                );

        itemDetailsResponseList.remove(itemDetailsResponse);
        itemDetailsResponseList.add(i, updatedItemDetailsResponse);

        itemsListAdapter.notifyDataSetChanged();
        calculateCartTotal();
    }

    @Override
    public void onAddClick(int position, ItemDetailsResponse itemDetailsResponse) {
        int i = itemDetailsResponseList.indexOf(itemDetailsResponse);
        ItemDetailsResponse updatedItemDetailsResponse = new ItemDetailsResponse(
                itemDetailsResponse.getId(), itemDetailsResponse.getItemname(), itemDetailsResponse.getSlug(), 1, itemDetailsResponse.getShop_id(), itemDetailsResponse.getCategory_id(),
                itemDetailsResponse.getSubcategory_id(),itemDetailsResponse.getPrice(),itemDetailsResponse.getDescription(),itemDetailsResponse.getChoices(),itemDetailsResponse.getImage(),itemDetailsResponse.getStatus(),itemDetailsResponse.getCreated_at(),itemDetailsResponse.getUpdated_at()

        );

        itemDetailsResponseList.remove(itemDetailsResponse);
        itemDetailsResponseList.add(i, updatedItemDetailsResponse);
        itemsListAdapter.notifyDataSetChanged();
        calculateCartTotal();

        addCart(customerId,itemDetailsResponse.getId(),1);
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

       /* btnAddtocart.setOnClickListener(view -> {

            if (btnAddtocart.getText().toString().equalsIgnoreCase("GOTO CART")){
                Intent intent = new Intent(ProductsActivity.this, HomeActivity.class);
                intent.putExtra(BOTTAM_TAB_POSITION,2);
                startActivity(intent);
            }else {
                addToCart(cartArray);
            }

        });*/



    }

    private void addCart(String customerId, int itemId, int qty){
        // init
        cartViewModel.initInsertCart(customerId,itemId,qty, requireActivity());

        // Alert toast msg
        cartViewModel.getToastObserver().observe(getViewLifecycleOwner(), message -> {
            // Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            Snackbar snackbar = Snackbar.make(binding.getRoot().getRootView(), message, Snackbar.LENGTH_LONG);
            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(Color.BLACK);
            snackbar.show();

            Util.noNetworkAlert(getActivity(), message);


        });

        // progress bar
        cartViewModel.getProgressbarObservable().observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                binding.progressBar.setVisibility(View.VISIBLE);

            } else {
                binding.progressBar.setVisibility(View.GONE);

            }
        });

        // get home data
        cartViewModel.getRepository().observe(getViewLifecycleOwner(), homeResponse -> {

            if (homeResponse.getStatus().equalsIgnoreCase("true")){
                Toast.makeText(getContext(),"Item Added to Cart",Toast.LENGTH_SHORT).show();
            }else {

            }


        });
    }
}