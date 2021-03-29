package com.buddy.basket.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.buddy.basket.R;
import com.buddy.basket.databinding.CatgoeryListItemBinding;
import com.buddy.basket.databinding.CatsublistItamBinding;
import com.buddy.basket.helper.UserSessionManager;
import com.buddy.basket.model.CategoriesResponse;
import com.buddy.basket.model.ShopsListResponse;
import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static com.buddy.basket.network.RetrofitService.IMAGE_HOME_URL;


public class CatSubListAdapter extends RecyclerView.Adapter<CatSubListAdapter.ViewHolder> {

    List<ShopsListResponse.DataBean> modelList;
    Context context;


    public CatSubListAdapter(List<ShopsListResponse.DataBean> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public CatSubListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(CatsublistItamBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CatSubListAdapter.ViewHolder holder, int position) {

        holder.rowItemBinding.txtShopName.setText(modelList.get(position).getShopname());

        Glide.with(context).load(IMAGE_HOME_URL + modelList.get(position).getImage())
                .error(R.drawable.placeholder).into(holder.rowItemBinding.imgShop);

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
        //return modelList.size();
        return Math.min(modelList.size(), 5);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        CatsublistItamBinding rowItemBinding;

        public ViewHolder(@NonNull CatsublistItamBinding rowItemBinding) {
            super(rowItemBinding.getRoot());
            this.rowItemBinding = rowItemBinding;
        }
    }


}