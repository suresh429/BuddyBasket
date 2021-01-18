package com.buddy.basket.fragments;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.buddy.basket.R;
import com.buddy.basket.activities.HomeActivity;
import com.buddy.basket.adapters.CartListAdapter;
import com.buddy.basket.databinding.FragmentCartBinding;
import com.buddy.basket.helper.UserSessionManager;
import com.buddy.basket.helper.Util;
import com.buddy.basket.model.CartModel;
import com.buddy.basket.model.CartResponse;
import com.buddy.basket.network.ApiInterface;
import com.buddy.basket.network.RetrofitService;
import com.buddy.basket.viewmodels.CartViewModel;
import com.bumptech.glide.Glide;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.buddy.basket.network.RetrofitService.IMAGE_HOME_URL;


public class CartFragment extends Fragment implements CartListAdapter.RestaurantItemInterface {

    FragmentCartBinding binding;
    CartListAdapter.RestaurantItemInterface restaurantItemInterface;
    CartViewModel cartViewModel;
    CartListAdapter adapter;
    private String customerId, shop_id;
    private final List<CartModel> cartModelList = new ArrayList<>();

    public static final String TAG = "CART_DATA";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //View root = inflater.inflate(R.layout.fragment_restaurants, container, false);
        binding = FragmentCartBinding.inflate(inflater, container, false);

        restaurantItemInterface = this;

        return binding.getRoot();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);

        UserSessionManager userSessionManager = new UserSessionManager(requireContext());
        HashMap<String, String> userDetails = userSessionManager.getUserDetails();
        customerId = userDetails.get("id");


        binding.actionLayout.textLocation.setText("Cart");
        binding.actionLayout.textLocation.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);

        cartListData();

    }

    private void cartListData() {
       /* // init
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

            if (homeResponse.getStatus().equalsIgnoreCase("true")) {

                List<CartResponse.CartBean> catDetailsBeanList = homeResponse.getCart();
                //dataBeanArrayList.addAll(catDetailsBeanList);
                cartModelList.clear();
                for (CartResponse.CartBean product : catDetailsBeanList) {
                    cartModelList.add(new CartModel(product.getId(), product.getCustomerId(), product.getItemId(), Integer.parseInt(product.getQty()), product.getItem().getItemname(),
                            Integer.parseInt(product.getItem().getQty()), Double.parseDouble(product.getItem().getPrice()), product.getItem().getShopId(), product.getItem().getCategoryId(),
                            product.getItem().getSubcategoryId(), product.getItem().getImage(), product.getItem().getChoices(), product.getItem().getStatus()
                    ));
                }

                adapter = new CartListAdapter(cartModelList, getActivity(), this);
                binding.recyclerHomeList.setAdapter(adapter);
                binding.progressBar.setVisibility(View.GONE);
                binding.errorLayout.txtError.setVisibility(View.GONE);
                adapter.notifyDataSetChanged();
                calculateCartTotal();

            } else {
                binding.progressBar.setVisibility(View.GONE);
                binding.errorLayout.txtError.setVisibility(View.VISIBLE);
                binding.errorLayout.txtError.setText("Empty Cart");
            }


        });*/

        binding.progressBar.setVisibility(View.VISIBLE);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("customer_id", customerId);
        Call<CartResponse> call = RetrofitService.createService(ApiInterface.class, requireContext()).getCartViewList(jsonObject);
        call.enqueue(new Callback<CartResponse>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NonNull Call<CartResponse> call, @NonNull Response<CartResponse> response) {

                if (response.isSuccessful()) {
                    binding.progressBar.setVisibility(View.GONE);
                    CartResponse homeResponse = response.body();

                    assert homeResponse != null;
                    if (homeResponse.getStatus().equalsIgnoreCase("true")) {

                        binding.txtShopName.setText(homeResponse.getCart().get(0).getShop().getShopname());
                        binding.txtAddreess.setText(homeResponse.getCart().get(0).getShop().getAddress());
                        binding.txtTime.setText(homeResponse.getCart().get(0).getShop().getOpentime() + " - " + homeResponse.getCart().get(0).getShop().getClosetime());
                        binding.txtMobile.setText(homeResponse.getCart().get(0).getShop().getPhone());
                        binding.txtDescription.setText(homeResponse.getCart().get(0).getShop().getDescription());
                        Glide.with(requireContext()).load(IMAGE_HOME_URL + homeResponse.getCart().get(0).getShop().getImage()).error(R.drawable.placeholder).into(binding.imgShop);


                        List<CartResponse.CartBean> catDetailsBeanList = homeResponse.getCart();
                        //dataBeanArrayList.addAll(catDetailsBeanList);
                        cartModelList.clear();
                        for (CartResponse.CartBean product : catDetailsBeanList) {
                            cartModelList.add(new CartModel(product.getId(), product.getCustomerId(), product.getItemId(), Integer.parseInt(product.getQty()), product.getItem().getItemname(),
                                    Integer.parseInt(product.getItem().getQty()), Double.parseDouble(product.getItem().getPrice()), product.getItem().getShopId(), product.getItem().getCategoryId(),
                                    product.getItem().getSubcategoryId(), product.getItem().getImage(), product.getItem().getChoices(), product.getItem().getStatus(), Integer.parseInt(product.getShop().getDeliveryCharges())
                            ));
                        }

                        adapter = new CartListAdapter(cartModelList, getActivity(), restaurantItemInterface);
                        binding.recyclerHomeList.setAdapter(adapter);
                        binding.progressBar.setVisibility(View.GONE);
                        binding.errorLayout.txtError.setVisibility(View.GONE);
                        binding.shopLayout.setVisibility(View.VISIBLE);
                        binding.noInternet.noInternet.setVisibility(View.GONE);
                        adapter.notifyDataSetChanged();
                        calculateCartTotal();

                    } else {
                        binding.progressBar.setVisibility(View.GONE);
                        binding.recyclerHomeList.setVisibility(View.GONE);
                        binding.shopLayout.setVisibility(View.GONE);
                        binding.errorLayout.txtError.setVisibility(View.VISIBLE);
                        binding.errorLayout.txtError.setText("Empty Cart");
                    }


                } else if (response.errorBody() != null) {
                    binding.progressBar.setVisibility(View.GONE);
                    binding.noInternet.noInternet.setVisibility(View.GONE);

                }
            }

            @Override
            public void onFailure(@NonNull Call<CartResponse> call, @NonNull Throwable t) {
                binding.progressBar.setVisibility(View.GONE);
                binding.noInternet.noInternet.setVisibility(View.VISIBLE);
            }
        });

        ((HomeActivity) requireActivity()).cartCount();

    }

    @Override
    public void onMinusClick(int position, CartModel cartModel) {
        int i = cartModelList.indexOf(cartModel);

        if (cartModel.getCart_qty() > 0) {

            CartModel updatedCartModel = new CartModel(
                    cartModel.getCartId(), cartModel.getCustomerId(), cartModel.getItemId(), cartModel.getCart_qty() - 1, cartModel.getItemName(),
                    cartModel.getTotal_qty(), cartModel.getPrice(), cartModel.getShopId(), cartModel.getCategoryId(),
                    cartModel.getSubCategoryId(), cartModel.getImage(), cartModel.getChoice(), cartModel.getStatus(), cartModel.getDeliveryCharge()
            );

            cartModelList.remove(cartModel);
            cartModelList.add(i, updatedCartModel);

            adapter.notifyDataSetChanged();


            updateCart(updatedCartModel);

            calculateCartTotal();
        }

    }

    @Override
    public void onPlusClick(int position, CartModel cartModel) {
        int i = cartModelList.indexOf(cartModel);

        CartModel updatedCartModel = new CartModel(
                cartModel.getCartId(), cartModel.getCustomerId(), cartModel.getItemId(), cartModel.getCart_qty() + 1, cartModel.getItemName(),
                cartModel.getTotal_qty(), cartModel.getPrice(), cartModel.getShopId(), cartModel.getCategoryId(),
                cartModel.getSubCategoryId(), cartModel.getImage(), cartModel.getChoice(), cartModel.getStatus(), cartModel.getDeliveryCharge());

        cartModelList.remove(cartModel);
        cartModelList.add(i, updatedCartModel);

        adapter.notifyDataSetChanged();

        updateCart(updatedCartModel);

        calculateCartTotal();
    }

    // total Amount
    @SuppressLint("SetTextI18n")
    public void calculateCartTotal() {
        int grandTotal = 0;
        int itemCount = 0;
        int deliveryCharge = 0;

        for (CartModel order : cartModelList) {

            grandTotal += order.getPrice() * order.getCart_qty();
            shop_id = order.getShopId();
            deliveryCharge = order.getDeliveryCharge();

            if (order.getCart_qty() > 0) {
                itemCount += order.getCart_qty();
            }
        }

        if (grandTotal != 0) {
            binding.actionBottomCart.txtItemPrice.setText("\u20B9 " + grandTotal);
            binding.actionBottomCart.txtItemCount.setText(cartModelList.size() + " ITEMS");
            binding.actionBottomCart.txtViewCart.setText("Check Out");
            binding.actionBottomCart.getRoot().setVisibility(View.VISIBLE);
            int finalGrandTotal = grandTotal;
            int finalItemCount = itemCount;
            int finalDeliveryCharge = deliveryCharge;
            binding.actionBottomCart.txtViewCart.setOnClickListener(v -> {
                Bundle bundle = new Bundle();
                bundle.putInt("grandTotal", finalGrandTotal);
                bundle.putInt("itemCount", finalItemCount);
                bundle.putString("shop_id", shop_id);
                bundle.putString("FROM", "Cart");
                bundle.putInt("DeliveryCharge", finalDeliveryCharge);
                Navigation.findNavController(v).navigate(R.id.addressListFragment, bundle);
            });
        } else {
            binding.actionBottomCart.getRoot().setVisibility(View.GONE);
        }

    }

    private void updateCart(CartModel cartModel) {
        // binding.progressBar.setVisibility(View.VISIBLE);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("customer_id", customerId);
        jsonObject.addProperty("item_id", cartModel.getItemId());
        jsonObject.addProperty("qty", cartModel.getCart_qty());
        Call<CartResponse> call = RetrofitService.createService(ApiInterface.class, requireContext()).getCartUpdateList(jsonObject);
        call.enqueue(new Callback<CartResponse>() {
            @Override
            public void onResponse(@NonNull Call<CartResponse> call, @NonNull Response<CartResponse> response) {

                if (response.isSuccessful()) {
                    binding.progressBar.setVisibility(View.GONE);
                    binding.noInternet.noInternet.setVisibility(View.GONE);

                    cartListData();

                } else if (response.errorBody() != null) {
                    binding.progressBar.setVisibility(View.GONE);
                    binding.noInternet.noInternet.setVisibility(View.GONE);

                }
            }

            @Override
            public void onFailure(@NonNull Call<CartResponse> call, @NonNull Throwable t) {
                Util.snackBar(requireView().getRootView(),t.getMessage(), Color.RED);
                binding.progressBar.setVisibility(View.GONE);
            }
        });
    }
}