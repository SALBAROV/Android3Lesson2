package com.example.android3lesson2.ui.fragments.episodes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android3lesson2.R;
import com.example.android3lesson2.data.dtos.RickyAndMortyResponce;
import com.example.android3lesson2.data.dtos.episodes.Episodes;
import com.example.android3lesson2.data.network.apiservices.EpisodesApiService;
import com.example.android3lesson2.databinding.FragmentCharacterBinding;
import com.example.android3lesson2.databinding.FragmentEpisodesBinding;
import com.example.android3lesson2.databinding.FragmentLocationBinding;
import com.example.android3lesson2.ui.adapters.CharacterAdapter;
import com.example.android3lesson2.ui.adapters.EpisodesAdapter;
import com.example.android3lesson2.ui.adapters.LocationAdapter;
import com.example.android3lesson2.ui.fragments.character.CharactersViewModel;
import com.example.android3lesson2.ui.fragments.location.LocationFragmentDirections;
import com.example.android3lesson2.ui.fragments.location.LocationViewModel;

public class EpisodesFragment extends Fragment {

    private EpisodesAdapter adapter = new EpisodesAdapter();
    private FragmentEpisodesBinding binding;
    private EpisodesViewModel viewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEpisodesBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
        setupRequest();
        setupObservers();
    }

    private void initialize() {
        viewModel = new ViewModelProvider(this).get(EpisodesViewModel.class);
        setupEpisodesRecycler();
    }

    private void setupEpisodesRecycler() {
        binding.recyclerEpisodes.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerEpisodes.setAdapter(adapter);
    }

    private void setupObservers() {
    }

    private void setupRequest() {
        viewModel.fetchEpisodes().observe(getViewLifecycleOwner(), episodes ->
                adapter.submitList(episodes.getResults()));

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}