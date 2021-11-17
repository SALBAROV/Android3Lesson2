package com.example.android3lesson2.ui.fragments.episodes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android3lesson2.R;
import com.example.android3lesson2.databinding.FragmentEpisodesBinding;

public class EpisodesFragment extends Fragment {

       FragmentEpisodesBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEpisodesBinding.inflate(getLayoutInflater(),container,false);
        return binding.getRoot();
    }
}