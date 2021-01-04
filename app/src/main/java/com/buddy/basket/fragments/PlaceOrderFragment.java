package com.buddy.basket.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.buddy.basket.R;
import com.buddy.basket.activities.HomeActivity;
import com.buddy.basket.databinding.FragmentPlaceorderBinding;
import com.buddy.basket.helper.UserSessionManager;
import com.buddy.basket.model.PlaceOrderResponse;
import com.buddy.basket.network.ApiInterface;
import com.buddy.basket.network.RetrofitService;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.buddy.basket.fragments.CartFragment.TAG;


public class PlaceOrderFragment extends Fragment {

    private FragmentPlaceorderBinding binding;
    String customerId,shop_id;
    Double deliveryCharge=30.00;
    int grandTotal,itemCount,address_id;

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPlaceorderBinding.inflate(inflater, container, false);

        UserSessionManager userSessionManager= new UserSessionManager(requireContext());
        HashMap<String, String> userDetails = userSessionManager.getUserDetails();
        customerId = userDetails.get("id");

        assert getArguments() != null;
        grandTotal=getArguments().getInt("grandTotal");
        itemCount=getArguments().getInt("itemCount");
        address_id=getArguments().getInt("address_id");
        shop_id=getArguments().getString("shop_id");

        binding.actionLayout.txtActionBarTitle.setText("Place Order");
        binding.actionLayout.badgeCart.setVisibility(View.GONE);
        binding.actionLayout.txtActionBarTitle.setOnClickListener(v -> Navigation.findNavController(v).popBackStack());

        binding.txtTotalCount.setText(""+itemCount);
        binding.txtTotalItems.setText("\u20b9"+ String.format("%.2f", (double)grandTotal));
        binding.txtDeliveryPrice.setText("\u20b9"+String.format("%.2f", deliveryCharge));

        Double total = grandTotal + deliveryCharge;
        binding.txtGrandTotal.setText("\u20b9"+String.format("%.2f", total));
        binding.btnPlaceOrder.setOnClickListener(v -> PlaceOrderData());
        return binding.getRoot();

    }

    private void PlaceOrderData(){
        binding.progressBar.setVisibility(View.VISIBLE);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("customer_id", customerId);
        jsonObject.addProperty("total_amt", grandTotal);
        jsonObject.addProperty("customer_comments", Objects.requireNonNull(binding.etComments.getText()).toString());
        jsonObject.addProperty("address_id", address_id);
        jsonObject.addProperty("shop_id", shop_id);
        Call<PlaceOrderResponse> call = RetrofitService.createService(ApiInterface.class,requireContext()).getPlaceOrderList(jsonObject);
        call.enqueue(new Callback<PlaceOrderResponse>() {
            @Override
            public void onResponse(@NonNull Call<PlaceOrderResponse> call, @NonNull Response<PlaceOrderResponse> response) {

                if (response.isSuccessful()) {
                    binding.progressBar.setVisibility(View.GONE);

                    assert response.body() != null;
                    displayAlert("Success",response.body().getMsg());

                } else if (response.errorBody() != null) {
                    binding.progressBar.setVisibility(View.GONE);
                    assert response.body() != null;
                    displayAlert("Failure",response.body().getMsg());
                   /* ApiError errorResponse = new Gson().fromJson(response.errorBody().charStream(), ApiError.class);
                    //Util.toast(context, "Session expired");
                    new Handler(Looper.getMainLooper()).post(() -> Toast.makeText(context, "Session expired", Toast.LENGTH_SHORT).show());
                    */
                }
            }

            @Override
            public void onFailure(@NonNull Call<PlaceOrderResponse> call, @NonNull Throwable t) {
                Toast.makeText(requireContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                binding.progressBar.setVisibility(View.GONE);
            }
        });
    }


    private void displayAlert(@NonNull String alertTitle, @Nullable String message) {


        ViewGroup viewGroup = binding.getRoot().findViewById(android.R.id.content);

        //then we will inflate the custom alert dialog xml that we created
        View dialogView = LayoutInflater.from(requireActivity()).inflate(R.layout.success_order_diloge, viewGroup, false);

        //Now we need an AlertDialog.Builder object
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());

        //setting the view of the builder to our custom view that we already inflated
        builder.setView(dialogView);

        //finally creating the alert dialog and displaying it
        AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(false);
        alertDialog.show();

        TextView txtTitle = dialogView.findViewById(R.id.txtTitle);
        TextView txtMsg = dialogView.findViewById(R.id.txtMsg);
        ImageView image = dialogView.findViewById(R.id.image);
        Button buttonOk = dialogView.findViewById(R.id.buttonOk);


        txtTitle.setText(alertTitle);
        txtMsg.setText(message);
        image.setImageResource(R.drawable.ic_success);
        buttonOk.setOnClickListener(v -> {
           // Navigation.findNavController(v).navigate(R.id.navigation_home);
            Intent intentLogin = new Intent(requireContext(), HomeActivity.class);
            intentLogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intentLogin);
            alertDialog.dismiss();

        });


    }



}