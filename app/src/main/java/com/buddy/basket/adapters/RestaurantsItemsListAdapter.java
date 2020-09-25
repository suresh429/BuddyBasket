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
import androidx.recyclerview.widget.RecyclerView;

import com.buddy.basket.R;
import com.buddy.basket.databinding.RestaurantsItemsListBinding;
import com.buddy.basket.model.Product;
import com.buddy.basket.model.ResItemsListResponse;
import com.buddy.basket.model.RestaurantListResponse;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

import java.util.List;

import static android.content.ContentValues.TAG;


public class RestaurantsItemsListAdapter extends RecyclerView.Adapter<RestaurantsItemsListAdapter.ViewHolder> {

    List<Product> modelList;
    Context context;
    RestaurantItemInterface restaurantItemInterface;
    public RestaurantsItemsListAdapter(List<Product> modelList, Context context,RestaurantItemInterface restaurantItemInterface) {
        this.modelList = modelList;
        this.context = context;
        this.restaurantItemInterface = restaurantItemInterface;
    }

    @NonNull
    @Override
    public RestaurantsItemsListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(RestaurantsItemsListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantsItemsListAdapter.ViewHolder holder, int position) {

        holder.rowItemBinding.txtItemName.setText(modelList.get(position).getPdtName());
        holder.rowItemBinding.txtItemPrice.setText("\u20B9"+modelList.get(position).getPrice());
        holder.rowItemBinding.txtItemCategory.setText(modelList.get(position).getCategory());

        if (modelList.get(position).getType().equalsIgnoreCase("Vegetarian")){
            holder.rowItemBinding.imgItemType.setImageResource(R.drawable.ic_baseline_green_24);
        }else {
            holder.rowItemBinding.imgItemType.setImageResource(R.drawable.ic_baseline_red_24);
        }

        Glide.with(context).load(modelList.get(position).getImage()).into(holder.rowItemBinding.imgItem);

        if (modelList.get(position).getQty() == 0) {
            holder.rowItemBinding.productQuantity.setText("ADD");
            holder.rowItemBinding.productMinus.setVisibility(View.GONE);
            holder.rowItemBinding.productPlus.setVisibility(View.GONE);
            Log.d(TAG, "onBindViewHolder: " + modelList.get(position).getQty());
        } else {
            holder.rowItemBinding.productQuantity.setText("" + modelList.get(position).getQty());
            holder.rowItemBinding.productMinus.setVisibility(View.VISIBLE);
            holder.rowItemBinding.productPlus.setVisibility(View.VISIBLE);
            Log.d(TAG, "onBindViewHolder1: " + modelList.get(position).getQty());
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


        holder.rowItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
               /* bundle.putString("catId", modelList.get(position).getCat_id());
                bundle.putString("catName", modelList.get(position).getCat_name());*/

               /* NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.categoryFragment,bundle);*/
                //Navigation.findNavController(v).navigate(R.id.categoryFragment,bundle);
            }
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
        void onMinusClick(int position,Product product);

        void onPlusClick(int position,Product product);

        void onAddClick(int position,Product product);
    }
}
