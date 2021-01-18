package com.buddy.basket.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.buddy.basket.R;
import com.buddy.basket.databinding.RestaurantsItemsListBinding;
import com.buddy.basket.model.ItemDetailsResponse;
import com.buddy.basket.model.ItemsListResponse;
import com.bumptech.glide.Glide;

import java.util.List;

import static android.content.ContentValues.TAG;
import static com.buddy.basket.network.RetrofitService.IMAGE_HOME_URL;


public class ItemsListAdapter extends RecyclerView.Adapter<ItemsListAdapter.ViewHolder> {

    List<ItemDetailsResponse> modelList;
    Context context;
     public RestaurantItemInterface restaurantItemInterface;
    public ItemsListAdapter(List<ItemDetailsResponse> modelList, Context context, RestaurantItemInterface restaurantItemInterface) {
        this.modelList = modelList;
        this.context = context;
        this.restaurantItemInterface = restaurantItemInterface;
    }

    @NonNull
    @Override
    public ItemsListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(RestaurantsItemsListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull ItemsListAdapter.ViewHolder holder, int position) {

        holder.rowItemBinding.txtItemName.setText(modelList.get(position).getItemname());
        holder.rowItemBinding.txtItemPrice.setText("\u20B9"+String.format("%.2f", modelList.get(position).getPrice()));
        holder.rowItemBinding.txtItemCategory.setText(modelList.get(position).getDescription());

        if (modelList.get(position).getChoices().equalsIgnoreCase("veg")){
            holder.rowItemBinding.imgItemType.setImageResource(R.drawable.ic_baseline_green_24);
        }else {
            holder.rowItemBinding.imgItemType.setImageResource(R.drawable.ic_baseline_red_24);
        }

        Glide.with(context).load(IMAGE_HOME_URL+modelList.get(position).getImage()).into(holder.rowItemBinding.imgItem);


        if (modelList.get(position).getQty() == 0) {
            holder.rowItemBinding.productQuantity.setText("ADD");
            holder.rowItemBinding.productMinus.setVisibility(View.GONE);
            holder.rowItemBinding.productPlus.setVisibility(View.GONE);
        } else {
            holder.rowItemBinding.productQuantity.setText("" + modelList.get(position).getQty());
            holder.rowItemBinding.productMinus.setVisibility(View.VISIBLE);
            holder.rowItemBinding.productPlus.setVisibility(View.VISIBLE);
        }

        holder.rowItemBinding.productQuantity.setOnClickListener(view -> {
            if (holder.rowItemBinding.productQuantity.getText().toString().equalsIgnoreCase("ADD")) {
                holder.rowItemBinding.productQuantity.setText("" + modelList.get(position).getQty());
                holder.rowItemBinding.productMinus.setVisibility(View.VISIBLE);
                holder.rowItemBinding.productPlus.setVisibility(View.VISIBLE);

                restaurantItemInterface.onAddClick(position, modelList.get(position));
            }
        });

        holder.rowItemBinding.productMinus.setOnClickListener(view -> {

            restaurantItemInterface.onMinusClick(position, modelList.get(position));

        });

        holder.rowItemBinding.productPlus.setOnClickListener(view -> {

            restaurantItemInterface.onPlusClick(position, modelList.get(position));

        });


    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        RestaurantsItemsListBinding rowItemBinding;

        public ViewHolder(@NonNull RestaurantsItemsListBinding rowItemBinding) {
            super(rowItemBinding.getRoot());
            this.rowItemBinding = rowItemBinding;
        }
    }

    public interface RestaurantItemInterface {
        void onMinusClick(int position, ItemDetailsResponse itemDetailsResponse);

        void onPlusClick(int position, ItemDetailsResponse itemDetailsResponse);

        void onAddClick(int position, ItemDetailsResponse itemDetailsResponse);
    }
}
