package com.buddy.basket.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
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
import com.buddy.basket.databinding.RestaurantItemBinding;
import com.buddy.basket.helper.UserSessionManager;
import com.buddy.basket.model.AddressResponse;
import com.buddy.basket.model.CategoriesResponse;
import com.buddy.basket.model.ShopsListResponse;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static com.buddy.basket.fragments.CartFragment.TAG;
import static com.buddy.basket.network.RetrofitService.IMAGE_HOME_URL;


public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> {

    List<CategoriesResponse.DataBean> modelList;
    Context context;
    CatSubListAdapter catSubListAdapter;
    List<CategoriesResponse.DataBean.ShopsBean> shopsBeanList;

    public CategoryListAdapter(List<CategoriesResponse.DataBean> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(CatgoeryListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryListAdapter.ViewHolder holder, int position) {

        shopsBeanList = modelList.get(position).getShops();
        holder.rowItemBinding.catName.setText(modelList.get(position).getCategoryname());

        Glide.with(context).load(IMAGE_HOME_URL + modelList.get(position).getImage())
                .error(R.drawable.placeholder).into(holder.rowItemBinding.catImage);

        catSubListAdapter = new CatSubListAdapter(shopsBeanList,context);
        holder.rowItemBinding.shopListRecycler.setAdapter(catSubListAdapter);

        if (shopsBeanList.size()==0){
            holder.rowItemBinding.getRoot().setVisibility(View.GONE);
        }

        holder.rowItemBinding.getRoot().setOnClickListener(v -> {

            UserSessionManager userSessionManager = new UserSessionManager(context);
            HashMap<String, String> location = userSessionManager.getLocationDetails();
            String cityId = location.get("cityId");

            Bundle bundle = new Bundle();
            bundle.putInt("city_id", Integer.parseInt(Objects.requireNonNull(cityId)));
            bundle.putInt("category_id", modelList.get(position).getId());
            bundle.putString("categoryname", modelList.get(position).getCategoryname());

            NavController navController = Navigation.findNavController(v);
            navController.navigate(R.id.shopsFragment, bundle);
        });
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        CatgoeryListItemBinding rowItemBinding;

        public ViewHolder(@NonNull CatgoeryListItemBinding rowItemBinding) {
            super(rowItemBinding.getRoot());
            this.rowItemBinding = rowItemBinding;
        }
    }


}