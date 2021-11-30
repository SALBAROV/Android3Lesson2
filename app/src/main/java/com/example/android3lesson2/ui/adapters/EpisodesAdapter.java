package com.example.android3lesson2.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android3lesson2.data.dtos.character.Character;
import com.example.android3lesson2.data.dtos.episodes.Episodes;
import com.example.android3lesson2.databinding.ItemEpisodesBinding;
import com.example.android3lesson2.ui.fragments.episodes.EpisodesViewModel;

import java.util.ArrayList;
import java.util.List;

public class EpisodesAdapter extends RecyclerView.Adapter<EpisodesAdapter.EpisodesViewHolder> {

    private ArrayList<Episodes> list = new ArrayList<>();

    @NonNull
    @Override
    public EpisodesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EpisodesViewHolder(ItemEpisodesBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull EpisodesViewHolder holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();

    }

    public void submitList(List<Episodes> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public class EpisodesViewHolder extends RecyclerView.ViewHolder {

        private ItemEpisodesBinding binding;

        public EpisodesViewHolder(ItemEpisodesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Episodes episodes) {
            binding.textEpisodesFullName.setText(episodes.getName());
        }
    }
    }

