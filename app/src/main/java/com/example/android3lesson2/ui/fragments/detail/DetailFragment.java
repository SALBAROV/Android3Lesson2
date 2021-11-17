package com.example.android3lesson2.ui.fragments.detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android3lesson2.R;
import com.example.android3lesson2.databinding.FragmentDetailBinding;


public class DetailFragment extends Fragment {
    FragmentDetailBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(getLayoutInflater(),container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupArgs();
    }

    private void setupArgs() {
     String name = DetailFragmentArgs.fromBundle(getArguments()).getId();
     binding.txtDetail.setText(name);
    }
}