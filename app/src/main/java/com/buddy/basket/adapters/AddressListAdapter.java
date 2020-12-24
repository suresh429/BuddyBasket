package com.buddy.basket.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.buddy.basket.databinding.AddressItemsListBinding;
import com.buddy.basket.databinding.LocationCardBinding;
import com.buddy.basket.model.AddressResponse;
import com.buddy.basket.model.CitiesResponse;

import java.util.List;


public class AddressListAdapter extends RecyclerView.Adapter<AddressListAdapter.ViewHolder> {

    List<AddressResponse.AddressesBean> modelList;
    Context mContext;
    AdapterListner adapterListner;
    String type;

    public AddressListAdapter(List<AddressResponse.AddressesBean> modelList, Context mContext, AdapterListner adapterListner, String type) {
        this.modelList = modelList;
        this.mContext = mContext;
        this.adapterListner = adapterListner;
        this.type = type;
    }

    @NonNull
    @Override
    public AddressListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(AddressItemsListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AddressListAdapter.ViewHolder holder, int position) {

        if (type.equalsIgnoreCase("ACCOUNT")){
            holder.rowItemBinding.btnSelect.setVisibility(View.GONE);
        }else {
            holder.rowItemBinding.btnSelect.setVisibility(View.VISIBLE);
        }

        holder.rowItemBinding.txtAddress.setText(modelList.get(position).getAddr1()+" , "+modelList.get(position).getAddr2()+" , "+modelList.get(position).getLandmark()+"\npincode : "+modelList.get(position).getPincode());
        holder.rowItemBinding.btnEdit.setOnClickListener(v -> adapterListner.editClick(modelList.get(position)));
        holder.rowItemBinding.btnDelete.setOnClickListener(v -> adapterListner.deleteClick(modelList.get(position)));
        holder.rowItemBinding.btnSelect.setOnClickListener(v -> adapterListner.selectClick(modelList.get(position)));

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        AddressItemsListBinding rowItemBinding;

        public ViewHolder(@NonNull AddressItemsListBinding rowItemBinding) {
            super(rowItemBinding.getRoot());
            this.rowItemBinding = rowItemBinding;
        }
    }

    public interface AdapterListner {
        void editClick(AddressResponse.AddressesBean product);
        void deleteClick(AddressResponse.AddressesBean product);
        void selectClick(AddressResponse.AddressesBean product);
    }
}
