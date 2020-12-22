package com.buddy.basket.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;


import com.buddy.basket.R;
import com.buddy.basket.databinding.RestaurantItemBinding;

import com.buddy.basket.databinding.ShopItemBinding;
import com.buddy.basket.model.ShopsListResponse;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;


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

    @Override
    public void onBindViewHolder(@NonNull ShopsListAdapter.ViewHolder holder, int position) {

        holder.rowItemBinding.txtShopName.setText(modelList.get(position).getShopname());
        holder.rowItemBinding.txtAddreess.setText(modelList.get(position).getAddress());
        holder.rowItemBinding.txtTime.setText(modelList.get(position).getOpentime()+" - "+modelList.get(position).getClosetime());
        holder.rowItemBinding.txtMobile.setText(modelList.get(position).getPhone());
        holder.rowItemBinding.txtDescription.setText(modelList.get(position).getDescription());

        Glide.with(context)
                .load(IMAGE_HOME_URL+modelList.get(position).getImage())
                .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE))
                .into(new CustomTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        holder.rowItemBinding.imgShop.setImageDrawable(resource);

                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {


                    }

                });

        holder.rowItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("shopId", modelList.get(position).getId());
                bundle.putString("shopName", modelList.get(position).getShopname());

                Navigation.findNavController(v).navigate(R.id.restaurantsItemsListFragment,bundle);
            }
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
