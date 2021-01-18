package com.buddy.basket.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.buddy.basket.R;
import com.buddy.basket.databinding.ShopItemBinding;
import com.buddy.basket.model.ShopsListResponse;
import com.bumptech.glide.Glide;

import java.util.List;

import static com.buddy.basket.network.RetrofitService.IMAGE_HOME_URL;


public class ShopsListAdapter extends RecyclerView.Adapter<ShopsListAdapter.ViewHolder> {

    List<ShopsListResponse.DataBean> modelList;

    Context context;

    public ShopsListAdapter(List<ShopsListResponse.DataBean> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ShopsListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ShopItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ShopsListAdapter.ViewHolder holder, int position) {

        holder.rowItemBinding.txtShopName.setText(modelList.get(position).getShopname());
        holder.rowItemBinding.txtAddreess.setText(modelList.get(position).getAddress());
        holder.rowItemBinding.txtTime.setText(modelList.get(position).getOpentime() + " - " + modelList.get(position).getClosetime());
        holder.rowItemBinding.txtMobile.setText(modelList.get(position).getPhone());
        holder.rowItemBinding.txtDescription.setText(modelList.get(position).getDescription());

        Glide.with(context)
                .load(IMAGE_HOME_URL + modelList.get(position).getImage())
                .error(R.drawable.placeholder)
                .into(holder.rowItemBinding.imgShop);

        holder.rowItemBinding.getRoot().setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putInt("shopId", modelList.get(position).getId());
            bundle.putString("shopName", modelList.get(position).getShopname());
            bundle.putString("shopImage", modelList.get(position).getImage());
            bundle.putString("shopLocation", modelList.get(position).getAddress());
            bundle.putString("shopDescription", modelList.get(position).getDescription());
            bundle.putString("shopOpenTime", modelList.get(position).getOpentime());
            bundle.putString("shopCloseTime", modelList.get(position).getClosetime());
            bundle.putString("shopContact", modelList.get(position).getPhone());

            Navigation.findNavController(v).navigate(R.id.restaurantsItemsListFragment, bundle);
        });
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        ShopItemBinding rowItemBinding;

        public ViewHolder(@NonNull ShopItemBinding rowItemBinding) {
            super(rowItemBinding.getRoot());
            this.rowItemBinding = rowItemBinding;
        }
    }
}
