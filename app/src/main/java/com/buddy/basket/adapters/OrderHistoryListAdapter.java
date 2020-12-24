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
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.buddy.basket.R;
import com.buddy.basket.databinding.HistoryListItemBinding;
import com.buddy.basket.databinding.ShopItemBinding;
import com.buddy.basket.model.OrderHistoryResponse;
import com.buddy.basket.model.ShopsListResponse;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.buddy.basket.network.RetrofitService.IMAGE_HOME_URL;


public class OrderHistoryListAdapter extends RecyclerView.Adapter<OrderHistoryListAdapter.ViewHolder> {

    List<OrderHistoryResponse.OrdersBean> modelList;

    Context context;
    public OrderHistoryListAdapter(List<OrderHistoryResponse.OrdersBean> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderHistoryListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(HistoryListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHistoryListAdapter.ViewHolder holder, int position) {

        /*holder.rowItemBinding.txtRestuarntName.setText(modelList.get(position).getShopname());
        holder.rowItemBinding.txtRestuarntLocation.setText(modelList.get(position).getAddress());*/

       /* @SuppressLint("SimpleDateFormat") SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        @SuppressLint("SimpleDateFormat") SimpleDateFormat outputFormat = new SimpleDateFormat("MMMM dd, yyyy");
        String inputDateStr="2020-12-13T16:05:58.000000Z";

        try {
            Date date = inputFormat.parse(modelList.get(position).getCreated_at());
            assert date != null;
            String outputDateStr = outputFormat.format(date);
            holder.rowItemBinding.txtDate.setText(outputDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/


        holder.rowItemBinding.txtAmount.setText("\u20b9"+modelList.get(position).getTotal_amt());
        holder.rowItemBinding.txtDate.setText(modelList.get(position).getCreated_at());
        /*Glide.with(context)
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

                });*/

        holder.rowItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("shopId", modelList.get(position).getId());

                //Navigation.findNavController(v).navigate(R.id.restaurantsItemsListFragment,bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        HistoryListItemBinding rowItemBinding;

        public ViewHolder(@NonNull HistoryListItemBinding rowItemBinding) {
            super(rowItemBinding.getRoot());
            this.rowItemBinding = rowItemBinding;
        }
    }
}
