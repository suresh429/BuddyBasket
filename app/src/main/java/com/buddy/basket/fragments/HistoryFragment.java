package com.buddy.basket.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.buddy.basket.R;
import com.buddy.basket.adapters.OrderHistoryListAdapter;
import com.buddy.basket.databinding.FragmentHistoryBinding;
import com.buddy.basket.helper.UserSessionManager;
import com.buddy.basket.model.OrderHistoryResponse;
import com.buddy.basket.viewmodels.OrderHistoryViewModel;

import java.util.HashMap;
import java.util.List;


public class HistoryFragment extends Fragment {

    OrderHistoryViewModel orderHistoryViewModel;
    FragmentHistoryBinding binding;
    OrderHistoryListAdapter adapter;
    String customerId;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        orderHistoryViewModel = new ViewModelProvider(this).get(OrderHistoryViewModel.class);
        binding = FragmentHistoryBinding.inflate(inflater, container, false);

        binding.actionLayout.textLocation.setText("Order History");
        binding.actionLayout.textLocation.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);


        UserSessionManager userSessionManager = new UserSessionManager(requireContext());
        HashMap<String, String> userDetails = userSessionManager.getUserDetails();
        customerId = userDetails.get("id");

        orderHistoryViewModel.initOrderHistory(customerId, requireActivity());
        // get home data
        orderHistoryViewModel.getRepository().observe(getViewLifecycleOwner(), homeResponse -> {

            if (homeResponse.getStatus().equalsIgnoreCase("true")){
                List<OrderHistoryResponse.OrdersBean> catDetailsBeanList = homeResponse.getOrders();
                adapter = new OrderHistoryListAdapter(catDetailsBeanList, getActivity());
                binding.recyclerHistory.setAdapter(adapter);
                binding.progressBar.setVisibility(View.GONE);
                binding.recyclerHistory.setVisibility(View.VISIBLE);
                binding.errorLayout.txtError.setVisibility(View.GONE);
                adapter.notifyDataSetChanged();
            }else {
                binding.errorLayout.txtError.setVisibility(View.VISIBLE);
                binding.progressBar.setVisibility(View.GONE);
                binding.recyclerHistory.setVisibility(View.GONE);
            }


        });


        return binding.getRoot();
    }
}