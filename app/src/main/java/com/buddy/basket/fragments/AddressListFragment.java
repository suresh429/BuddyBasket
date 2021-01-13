package com.buddy.basket.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.buddy.basket.R;
import com.buddy.basket.adapters.AddressListAdapter;
import com.buddy.basket.databinding.FragmentAddressListBinding;
import com.buddy.basket.databinding.FragmentCartBinding;
import com.buddy.basket.helper.UserSessionManager;
import com.buddy.basket.helper.Util;
import com.buddy.basket.model.AddressResponse;
import com.buddy.basket.model.CartResponse;
import com.buddy.basket.network.ApiInterface;
import com.buddy.basket.network.RetrofitService;

import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;


public class AddressListFragment extends Fragment implements AddressListAdapter.AdapterListner{

    private FragmentAddressListBinding binding;
    AddressListAdapter adapter;
    String customerId,from,shop_id;
    AddressListAdapter.AdapterListner adapterListner;

    int grandTotal,itemCount,deliveryCharge;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAddressListBinding.inflate(inflater, container, false);

        UserSessionManager userSessionManager= new UserSessionManager(requireContext());
        HashMap<String, String> userDetails = userSessionManager.getUserDetails();
        customerId = userDetails.get("id");

        adapterListner = this;

        if (getArguments() != null){
            grandTotal=getArguments().getInt("grandTotal");
            itemCount=getArguments().getInt("itemCount");
            from = getArguments().getString("FROM");
            shop_id = getArguments().getString("shop_id");
            deliveryCharge = getArguments().getInt("DeliveryCharge");
        }


        binding.actionLayout.txtActionBarTitle.setText("Select Address");
        binding.actionLayout.badgeCart.setVisibility(View.GONE);
        binding.actionLayout.txtActionBarTitle.setOnClickListener(v ->
                Navigation.findNavController(v).popBackStack()
        );

        binding.btnAddNewAddress.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("FROM",from);
            bundle.putInt("grandTotal",grandTotal);
            bundle.putInt("itemCount",itemCount);
            bundle.putInt("DeliveryCharge",deliveryCharge);
            Navigation.findNavController(binding.getRoot()).navigate(R.id.addAddressFragment,bundle);
        });

        AddressListData();

        return binding.getRoot();

    }

    private void AddressListData(){
        binding.progressBar.setVisibility(View.VISIBLE);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("customer_id", customerId);
        Call<AddressResponse> call = RetrofitService.createService(ApiInterface.class,requireContext()).getAddressList(jsonObject);
        call.enqueue(new Callback<AddressResponse>() {
            @Override
            public void onResponse(@NonNull Call<AddressResponse> call, @NonNull Response<AddressResponse> response) {

                if (response.isSuccessful()) {
                    binding.progressBar.setVisibility(View.GONE);
                    List<AddressResponse.AddressesBean> addressesBeanList = response.body().getAddresses();

                    if (addressesBeanList.size() > 0){

                        try {

                            adapter = new AddressListAdapter(addressesBeanList,requireContext(),adapterListner,from);
                            binding.recyclerAddressList.setAdapter(adapter);
                            adapter.notifyDataSetChanged();

                            binding.errorLayout.txtError.setVisibility(View.GONE);
                            binding.recyclerAddressList.setVisibility(View.VISIBLE);

                        } catch (IllegalArgumentException | IllegalStateException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                    }else {
                        /*Navigation.findNavController(binding.getRoot()).navigate(R.id.addAddressFragment);*/
                        binding.errorLayout.txtError.setVisibility(View.VISIBLE);
                        binding.recyclerAddressList.setVisibility(View.GONE);
                    }

                } else if (response.errorBody() != null) {
                    binding.progressBar.setVisibility(View.GONE);
                   /* ApiError errorResponse = new Gson().fromJson(response.errorBody().charStream(), ApiError.class);
                    //Util.toast(context, "Session expired");
                    new Handler(Looper.getMainLooper()).post(() -> Toast.makeText(context, "Session expired", Toast.LENGTH_SHORT).show());
                    */
                }
            }

            @Override
            public void onFailure(@NonNull Call<AddressResponse> call, @NonNull Throwable t) {
                Toast.makeText(requireContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                binding.progressBar.setVisibility(View.GONE);
            }
        });
    }


    @Override
    public void editClick(AddressResponse.AddressesBean product) {

        Bundle bundle = new Bundle();
        bundle.putString("name",product.getName());
        bundle.putString("phone",product.getPhone());
        bundle.putString("address1",product.getAddr1());
        bundle.putString("address2",product.getAddr2());
        bundle.putString("landmark",product.getLandmark());
        bundle.putString("pincode",product.getPincode());
        bundle.putInt("address_id",product.getId());
        bundle.putString("shop_id",shop_id);
        bundle.putString("FROM",from);
        bundle.putInt("grandTotal",grandTotal);
        bundle.putInt("itemCount",itemCount);
        bundle.putInt("DeliveryCharge",deliveryCharge);

        Navigation.findNavController(binding.getRoot()).navigate(R.id.updateAddressFragment,bundle);
    }

    @Override
    public void deleteClick(AddressResponse.AddressesBean product) {
        binding.progressBar.setVisibility(View.VISIBLE);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("customer_id", customerId);
        jsonObject.addProperty("id", product.getId());
        Call<AddressResponse> call = RetrofitService.createService(ApiInterface.class,requireContext()).getAddressDeleteList(jsonObject);
        call.enqueue(new Callback<AddressResponse>() {
            @Override
            public void onResponse(@NonNull Call<AddressResponse> call, @NonNull Response<AddressResponse> response) {

                if (response.isSuccessful()) {
                    binding.progressBar.setVisibility(View.GONE);
                    adapter.notifyDataSetChanged();
                    Util.snackBar(binding.getRoot(),"Address Deleted!", Color.RED);
                    AddressListData();

                } else if (response.errorBody() != null) {
                    binding.progressBar.setVisibility(View.GONE);
                   /* ApiError errorResponse = new Gson().fromJson(response.errorBody().charStream(), ApiError.class);
                    //Util.toast(context, "Session expired");
                    new Handler(Looper.getMainLooper()).post(() -> Toast.makeText(context, "Session expired", Toast.LENGTH_SHORT).show());
                    */
                }
            }

            @Override
            public void onFailure(@NonNull Call<AddressResponse> call, @NonNull Throwable t) {
                Toast.makeText(requireContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                binding.progressBar.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void selectClick(AddressResponse.AddressesBean product) {
        Bundle bundle = new Bundle();
        bundle.putInt("grandTotal",grandTotal);
        bundle.putInt("itemCount",itemCount);
        bundle.putInt("address_id",product.getId());
        bundle.putString("shop_id",shop_id);
        bundle.putInt("DeliveryCharge",deliveryCharge);

        Navigation.findNavController(binding.getRoot()).navigate(R.id.placeOrderFragment,bundle);
    }
}