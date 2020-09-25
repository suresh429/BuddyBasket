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

import com.buddy.basket.model.RestaurantListResponse;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;


import java.util.List;


public class RestaurantsListAdapter extends RecyclerView.Adapter<RestaurantsListAdapter.ViewHolder> {

    List<RestaurantListResponse.DataBean> modelList;

    Context context;
    public RestaurantsListAdapter(List<RestaurantListResponse.DataBean> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public RestaurantsListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(RestaurantItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantsListAdapter.ViewHolder holder, int position) {

        holder.rowItemBinding.txtRestaruantName.setText(modelList.get(position).getRestaurant_Name());
        holder.rowItemBinding.txtAddreess.setText(modelList.get(position).getAddress());
        holder.rowItemBinding.txtAvgPrepTime.setText(modelList.get(position).getAvgPrepTime());
        holder.rowItemBinding.txtKnownFor.setText(modelList.get(position).getKnownFor());
      //  holder.rowItemBinding.txtOperationStatus.setText(modelList.get(position).getOperationStatus());

        Glide.with(context)
                .load(modelList.get(position).getRestaurantLogo())
                .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE))
                .into(new CustomTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        holder.rowItemBinding.imgRestaruant.setImageDrawable(resource);

                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {


                    }

                });

        holder.rowItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("id", modelList.get(position).getRestaurant_ID());
                bundle.putString("name", modelList.get(position).getRestaurant_Name());
                bundle.putString("type", modelList.get(position).getKnownFor());
                bundle.putString("time", modelList.get(position).getAvgPrepTime());
                bundle.putString("address", modelList.get(position).getAddress());


                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.restaurantsItemsListFragment,bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        RestaurantItemBinding rowItemBinding;

        public ViewHolder(@NonNull RestaurantItemBinding rowItemBinding) {
            super(rowItemBinding.getRoot());
            this.rowItemBinding = rowItemBinding;
        }
    }
}
