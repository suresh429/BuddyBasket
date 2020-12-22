package com.buddy.basket.adapters;

import android.app.AlertDialog;
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
import com.buddy.basket.databinding.CatgoeryListItemBinding;
import com.buddy.basket.databinding.LocationCardBinding;
import com.buddy.basket.helper.UserSessionManager;
import com.buddy.basket.model.CategoriesResponse;
import com.buddy.basket.model.CitiesResponse;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

import java.util.List;

import static com.buddy.basket.network.RetrofitService.IMAGE_HOME_URL;


public class LocationListAdapter extends RecyclerView.Adapter<LocationListAdapter.ViewHolder> {

    List<CitiesResponse.DataBean> modelList;
    Context mContext;
    AdapterListner adapterListner;

    public LocationListAdapter(List<CitiesResponse.DataBean> modelList, Context mContext, AdapterListner adapterListner) {
        this.modelList = modelList;
        this.mContext = mContext;
        this.adapterListner = adapterListner;
    }

    @NonNull
    @Override
    public LocationListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LocationCardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LocationListAdapter.ViewHolder holder, int position) {

        holder.rowItemBinding.txtLocation.setText(modelList.get(position).getCity());
        holder.rowItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterListner.onClick(modelList.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        LocationCardBinding rowItemBinding;

        public ViewHolder(@NonNull LocationCardBinding rowItemBinding) {
            super(rowItemBinding.getRoot());
            this.rowItemBinding = rowItemBinding;
        }
    }

    public interface AdapterListner {
        void onClick(CitiesResponse.DataBean product);
    }
}
