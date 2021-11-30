package com.example.android3lesson2.ui.fragments.location;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android3lesson2.R;
import com.example.android3lesson2.data.dtos.RickyAndMortyResponce;
import com.example.android3lesson2.data.dtos.location.Locations;
import com.example.android3lesson2.databinding.FragmentCharacterBinding;
import com.example.android3lesson2.databinding.FragmentLocationBinding;
import com.example.android3lesson2.ui.adapters.LocationAdapter;

import java.util.ArrayList;


public class LocationFragment extends Fragment {

   private FragmentLocationBinding binding;
    private LocationAdapter adapter = new LocationAdapter();
    private LocationViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLocationBinding.inflate(getLayoutInflater(),container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
        setupRequest();

    }
    private void initialize() {
        viewModel= new ViewModelProvider(this).get(LocationViewModel.class);
        adapter= new LocationAdapter();
        setupLocationRecycler();

    }

    private void setupLocationRecycler() {
        binding.recyclerLocation.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerLocation.setAdapter(adapter);
    }

    private void setupRequest() {
        viewModel.fetchLocations().observe(getViewLifecycleOwner(), locations ->
                adapter.submitList(locations.getResults()));
    }






    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}