package com.example.android3lesson2.ui.fragments.character;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android3lesson2.R;
import com.example.android3lesson2.databinding.FragmentCharacterBinding;


public class CharacterFragment extends Fragment {

   FragmentCharacterBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCharacterBinding.inflate(getLayoutInflater(),container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated( View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}