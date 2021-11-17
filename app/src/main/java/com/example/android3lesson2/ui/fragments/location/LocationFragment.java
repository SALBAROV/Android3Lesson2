package com.example.android3lesson2.ui.fragments.location;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android3lesson2.R;
import com.example.android3lesson2.databinding.FragmentCharacterBinding;
import com.example.android3lesson2.databinding.FragmentLocationBinding;


public class LocationFragment extends Fragment {

    FragmentLocationBinding binding;

    String name = "How a you";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLocationBinding.inflate(getLayoutInflater(),container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listener();
    }

    private void listener() {
        binding.btnOpenDetailFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(LocationFragmentDirections.actionGlobalDetailFragment().setId(name));
            }
        });
    }
}