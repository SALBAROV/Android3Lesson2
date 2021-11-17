package com.example.android3lesson2.ui.fragments.episodes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android3lesson2.R;
import com.example.android3lesson2.databinding.FragmentEpisodesBinding;
import com.example.android3lesson2.databinding.FragmentLocationBinding;
import com.example.android3lesson2.ui.fragments.location.LocationFragmentDirections;

public class EpisodesFragment extends Fragment {

    FragmentEpisodesBinding binding;

    String name = "Geektech";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEpisodesBinding.inflate(getLayoutInflater(),container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated( View view, @Nullable Bundle savedInstanceState) {
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