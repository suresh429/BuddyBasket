package com.buddy.basket.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.buddy.basket.R;
import com.buddy.basket.adapters.CartListAdapter;
import com.buddy.basket.adapters.ItemsListAdapter;
import com.buddy.basket.databinding.FragmentCartBinding;
import com.buddy.basket.helper.UserSessionManager;
import com.buddy.basket.helper.Util;
import com.buddy.basket.model.CartModel;
import com.buddy.basket.model.CartResponse;
import com.buddy.basket.model.ItemDetailsResponse;
import com.buddy.basket.model.ItemsListResponse;
import com.buddy.basket.viewmodels.CartUpdateViewModel;
import com.buddy.basket.viewmodels.CartViewModel;
import com.buddy.basket.viewmodels.ItemsListViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.content.ContentValues.TAG;


public class CartFragment extends Fragment implements CartListAdapter.RestaurantItemInterface{

    CartViewModel cartViewModel;
    CartUpdateViewModel cartUpdateViewModel;
    FragmentCartBinding binding;
    CartListAdapter adapter;
    private String customerId;
    private List<CartModel> cartModelList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //View root = inflater.inflate(R.layout.fragment_restaurants, container, false);
        binding = FragmentCartBinding.inflate(inflater, container, false);

        UserSessionManager userSessionManager= new UserSessionManager(requireContext());
        HashMap<String, String> userDetails = userSessionManager.getUserDetails();
        customerId = userDetails.get("id");

        cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);
        cartUpdateViewModel = new ViewModelProvider(this).get(CartUpdateViewModel.class);

        binding.actionLayout.txtActionBarTitle.setText("Cart");
        binding.actionLayout.badgeCart.setVisibility(View.GONE);
        binding.actionLayout.txtActionBarTitle.setOnClickListener(v -> Navigation.findNavController(v).popBackStack());

        cartListData();
        return binding.getRoot();
    }

    private void cartListData() {
        // init
        cartViewModel.initViewCart(customerId, requireActivity());

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

                List<CartResponse.CartBean> catDetailsBeanList = homeResponse.getCart();
                //dataBeanArrayList.addAll(catDetailsBeanList);

                for (CartResponse.CartBean product : catDetailsBeanList) {
                    cartModelList.add(new CartModel(product.getId(), product.getCustomer_id(), product.getItem_id(), Integer.parseInt(product.getQty()), product.getItem().getItemname(),
                            Integer.parseInt(product.getItem().getQty()),Double.parseDouble(product.getItem().getPrice()),product.getItem().getShop_id(),product.getItem().getCategory_id(),
                            product.getItem().getSubcategory_id(),product.getItem().getImage(),product.getItem().getChoices(),product.getItem().getStatus()
                            ));
                }

                adapter = new CartListAdapter(cartModelList, getActivity(), this);
                binding.recyclerHomeList.setAdapter(adapter);
                binding.progressBar.setVisibility(View.GONE);
                binding.errorLayout.txtError.setVisibility(View.GONE);
                adapter.notifyDataSetChanged();
                calculateCartTotal();

            }else {
                binding.progressBar.setVisibility(View.GONE);
                binding.errorLayout.txtError.setVisibility(View.VISIBLE);
            }


        });

    }


    @Override
    public void onMinusClick(int position, CartModel cartModel) {
        int i = cartModelList.indexOf(cartModel);
        Log.d(TAG, "onMinusClick: "+ cartModel.getCart_qty());
        if (cartModel.getCart_qty() > 0) {

            CartModel updatedCartModel = new CartModel(
                    cartModel.getCartId(), cartModel.getCustomerId(), cartModel.getItemId(), cartModel.getCart_qty()-1, cartModel.getItemName(),
                    cartModel.getTotal_qty(),cartModel.getPrice(),cartModel.getShopId(),cartModel.getCategoryId(),
                    cartModel.getSubCategoryId(),cartModel.getImage(),cartModel.getChoice(),cartModel.getStatus()
            );

            cartModelList.remove(cartModel);
            cartModelList.add(i, updatedCartModel);

            adapter.notifyDataSetChanged();
            Log.d(TAG, "onMinusClick1: "+ cartModel.getCart_qty());

            updateCart(updatedCartModel);

            calculateCartTotal();
        }

    }

    @Override
    public void onPlusClick(int position, CartModel cartModel) {
        int i = cartModelList.indexOf(cartModel);
        CartModel updatedCartModel = new CartModel(
                cartModel.getCartId(), cartModel.getCustomerId(), cartModel.getItemId(), cartModel.getCart_qty()+1, cartModel.getItemName(),
                cartModel.getTotal_qty(),cartModel.getPrice(),cartModel.getShopId(),cartModel.getCategoryId(),
                cartModel.getSubCategoryId(),cartModel.getImage(),cartModel.getChoice(),cartModel.getStatus());

        cartModelList.remove(cartModel);
        cartModelList.add(i, updatedCartModel);

        adapter.notifyDataSetChanged();

        updateCart(updatedCartModel);

        calculateCartTotal();
    }


    // total Amount
    public void calculateCartTotal() {

        int grandTotal = 0;
        int itemCount = 0;
        for (CartModel order : cartModelList) {

            grandTotal += order.getPrice() * order.getCart_qty();

            if (order.getCart_qty() > 0) {
                itemCount += order.getCart_qty();
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

    private void updateCart(CartModel cartModel){
        // init
        cartUpdateViewModel.initUpdateCart(customerId, Integer.parseInt(cartModel.getItemId()),cartModel.getCart_qty(), requireActivity());

        // Alert toast msg
        cartUpdateViewModel.getToastObserver().observe(getViewLifecycleOwner(), message -> {
            // Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            Snackbar snackbar = Snackbar.make(binding.getRoot().getRootView(), message, Snackbar.LENGTH_LONG);
            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(Color.BLACK);
            snackbar.show();

            Util.noNetworkAlert(getActivity(), message);


        });

        // progress bar
        cartUpdateViewModel.getProgressbarObservable().observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                binding.progressBar.setVisibility(View.VISIBLE);

            } else {
                binding.progressBar.setVisibility(View.GONE);

            }
        });

        // get home data
        cartUpdateViewModel.getRepository().observe(getViewLifecycleOwner(), homeResponse -> {

            if (homeResponse.getStatus().equalsIgnoreCase("true")){
                Toast.makeText(getContext(),"Item Update to Cart",Toast.LENGTH_SHORT).show();
            }else {

            }


        });
    }
}