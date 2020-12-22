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
import com.buddy.basket.databinding.CatgoeryListItemBinding;
import com.buddy.basket.databinding.RestaurantItemBinding;
import com.buddy.basket.model.CategoriesResponse;
import com.buddy.basket.model.ShopsListResponse;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

import java.util.List;

import static com.buddy.basket.network.RetrofitService.IMAGE_HOME_URL;


public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> {

    List<CategoriesResponse.DataBean> modelList;
    int cityId;

    Context context;
    public CategoryListAdapter(List<CategoriesResponse.DataBean> modelList, int cityId, Context context) {
        this.modelList = modelList;
        this.cityId = cityId;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(CatgoeryListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryListAdapter.ViewHolder holder, int position) {

        holder.rowItemBinding.catName.setText(modelList.get(position).getCategoryname());

        Glide.with(context)
                .load(IMAGE_HOME_URL+modelList.get(position).getImage())
                .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE))
                .into(new CustomTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        holder.rowItemBinding.catImage.setImageDrawable(resource);

                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {


                    }

                });

        holder.rowItemBinding.getRoot().setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putInt("city_id", cityId);
            bundle.putInt("category_id", modelList.get(position).getId());
            bundle.putString("categoryname", modelList.get(position).getCategoryname());
            //bundle.putString("type", modelList.get(position).getShopname());

            NavController navController = Navigation.findNavController(v);
            navController.navigate(R.id.shopsFragment,bundle);
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
