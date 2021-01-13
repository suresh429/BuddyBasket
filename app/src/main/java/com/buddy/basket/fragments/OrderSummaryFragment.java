package com.buddy.basket.fragments;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.buddy.basket.adapters.OrderHistoryListAdapter;
import com.buddy.basket.adapters.OrderItemListAdapter;
import com.buddy.basket.databinding.FragmentHistoryBinding;
import com.buddy.basket.databinding.FragmentOrderSummaryBinding;
import com.buddy.basket.helper.UserSessionManager;
import com.buddy.basket.model.OrderHistoryResponse;
import com.buddy.basket.viewmodels.OrderHistoryViewModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

import java.sql.ClientInfoStatus;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static com.buddy.basket.fragments.CartFragment.TAG;
import static com.buddy.basket.network.RetrofitService.IMAGE_HOME_URL;


public class OrderSummaryFragment extends Fragment {

    OrderHistoryViewModel orderHistoryViewModel;
    FragmentOrderSummaryBinding binding;
    OrderItemListAdapter adapter;
    int position;
    List<OrderHistoryResponse.OrdersBean> ordersBeanList;
    List<OrderHistoryResponse.OrdersBean.OrderItemBean> orderItemBeanList;
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        orderHistoryViewModel = new ViewModelProvider(this).get(OrderHistoryViewModel.class);
        binding = FragmentOrderSummaryBinding.inflate(inflater, container, false);

        binding.actionLayout.txtActionBarTitle.setText("Order Summary");
        binding.actionLayout.badgeCart.setVisibility(View.GONE);
        binding.actionLayout.txtActionBarTitle.setOnClickListener(v -> Navigation.findNavController(v).popBackStack());


        Bundle bundle = getArguments();
        if (bundle != null) {
            ordersBeanList =  bundle.getParcelableArrayList("shopListArray");
            orderItemBeanList =  bundle.getParcelableArrayList("orderListArray");
            position = bundle.getInt("position");
        }

       /* for (OrderHistoryResponse.OrdersBean ordersBean : ordersBeanList){
            orderItemBeanList = ordersBean.getOrderItem();
        }*/
        adapter = new OrderItemListAdapter(orderItemBeanList,position, getActivity());
        binding.recyclerHistory.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        binding.txtRestuarntName.setText(ordersBeanList.get(position).getShop().getShopname());
        binding.txtRestuarntLocation.setText(ordersBeanList.get(position).getShop().getAddress());
        Glide.with(requireActivity())
                .load(IMAGE_HOME_URL + ordersBeanList.get(position).getShop().getImage())
                .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE))
                .into(new CustomTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        binding.imgShop.setImageDrawable(resource);

                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {


                    }

                });


        binding.txtOrderStatus.setText("This Order was "+ordersBeanList.get(position).getStatus());
        binding.txtItemTotalPrice.setText("\u20b9"+ordersBeanList.get(position).getTotalAmt());
        binding.txtDeliveryPrice.setText("\u20b9"+ ordersBeanList.get(position).getDeliveryCharges());

        double total = Double.parseDouble(ordersBeanList.get(position).getTotalAmt()) + Double.parseDouble(ordersBeanList.get(position).getDeliveryCharges());
        binding.txtGrandTotalAmount.setText("\u20b9"+String.format("%.2f", total));
        binding.txtOrderNumber.setText(""+ordersBeanList.get(position).getId());
        binding.txtOrderMode.setText("Cash on Delivery");
        binding.txtOrderPhone.setText(ordersBeanList.get(position).getAddress().getPhone());
        binding.txtOrderAddress.setText(ordersBeanList.get(position).getAddress().getAddr1()+","+
                ordersBeanList.get(position).getAddress().getAddr2()+","+
                ordersBeanList.get(position).getAddress().getLandmark()+","+
                ordersBeanList.get(position).getAddress().getPincode());

        return binding.getRoot();
    }
}