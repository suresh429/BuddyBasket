package com.buddy.basket.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.buddy.basket.R;
import com.buddy.basket.adapters.ShopsListAdapter;
import com.buddy.basket.databinding.FragmentCategoriesBinding;
import com.buddy.basket.databinding.FragmentShopsNamesBinding;
import com.buddy.basket.model.CategoriesResponse;
import com.buddy.basket.model.ShopsListResponse;
import com.buddy.basket.viewmodels.CategoriesViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static android.content.ContentValues.TAG;


public class CategoriesFragment extends Fragment {

    private CategoriesViewModel categoriesViewModel;
    ArrayList<CategoriesResponse.DataBean> dataBeanArrayList = new ArrayList<>();
    FragmentCategoriesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        categoriesViewModel = new ViewModelProvider(this).get(CategoriesViewModel.class);
        binding = FragmentCategoriesBinding.inflate(inflater,container,false);


        categoriesViewModel.initCategories(requireActivity());
        // get home data
        categoriesViewModel.getRepository().observe(getViewLifecycleOwner(), homeResponse -> {
            List<CategoriesResponse.DataBean> catDetailsBeanList = homeResponse.getData();

            dataBeanArrayList.addAll(catDetailsBeanList);

            for (CategoriesResponse.DataBean dataBean : catDetailsBeanList){

                Log.d(TAG, "onCreateView: "+dataBean.getCategoryname());
            }

           /* shopsListAdapter = new ShopsListAdapter(catDetailsBeanList,getActivity());
            binding.recyclerHomeList.setAdapter(shopsListAdapter);



            binding.progressBar.setVisibility(View.GONE);

            shopsListAdapter.notifyDataSetChanged();*/

        });


        return binding.getRoot();
    }
}