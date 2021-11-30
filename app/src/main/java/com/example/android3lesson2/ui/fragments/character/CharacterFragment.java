package com.example.android3lesson2.ui.fragments.character;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android3lesson2.data.dtos.RickyAndMortyResponce;
import com.example.android3lesson2.data.dtos.character.Character;
import com.example.android3lesson2.databinding.FragmentCharacterBinding;
import com.example.android3lesson2.ui.adapters.CharacterAdapter;


public class CharacterFragment extends Fragment {

    private CharacterAdapter characterAdapter = new CharacterAdapter();
    private FragmentCharacterBinding binding;
    private CharactersViewModel viewModel;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCharacterBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listener();
        initialization();
        setupReguests();
        setupObservers();
    }

    private void initialization() {
        viewModel = new ViewModelProvider(this).get(CharactersViewModel.class);
        setupCharacterRecycler();
    }

    private void setupCharacterRecycler() {
        binding.recyclerCharacter.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerCharacter.setAdapter(characterAdapter);
    }

    private void setupObservers() {

    }

    private void listener() {

    }

    private void setupReguests() {
        viewModel.fetchCharacter().observe(getViewLifecycleOwner(), character -> {
            characterAdapter.submitlist(character.getResults());
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}


