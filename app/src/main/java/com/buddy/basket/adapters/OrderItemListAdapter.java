package com.buddy.basket.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.buddy.basket.databinding.HistoryListItemBinding;
import com.buddy.basket.databinding.OrderSummaryListItemBinding;
import com.buddy.basket.model.OrderHistoryResponse;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

import java.util.List;

import static com.buddy.basket.network.RetrofitService.IMAGE_HOME_URL;


public class OrderItemListAdapter extends RecyclerView.Adapter<OrderItemListAdapter.ViewHolder> {

    List<OrderHistoryResponse.OrdersBean.OrderItemBean> modelList;
    Context context;
    int FromPosition;
    public OrderItemListAdapter(List<OrderHistoryResponse.OrdersBean.OrderItemBean> modelList, int FromPosition, Context context) {
        this.modelList = modelList;
        this.FromPosition = FromPosition;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderItemListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(OrderSummaryListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull OrderItemListAdapter.ViewHolder holder, int position) {

        OrderHistoryResponse.OrdersBean.OrderItemBean ordersBean = modelList.get(position);

        holder.rowItemBinding.txtItem.setText(ordersBean.getItem().getItemname());
        holder.rowItemBinding.txtItemQty.setText(ordersBean.getQty());
        holder.rowItemBinding.txtItemPrice.setText(ordersBean.getItem().getPrice());
        holder.rowItemBinding.txtItemTotalPrice.setText("\u20b9"+ordersBean.getPrice());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        OrderSummaryListItemBinding rowItemBinding;

        public ViewHolder(@NonNull OrderSummaryListItemBinding rowItemBinding) {
            super(rowItemBinding.getRoot());
            this.rowItemBinding = rowItemBinding;
        }
    }
}
