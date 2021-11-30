package com.example.android3lesson2.ui.adapters;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android3lesson2.data.dtos.character.Character;
import com.example.android3lesson2.data.dtos.episodes.Episodes;
import com.example.android3lesson2.databinding.ItemCharacterBinding;

import java.util.ArrayList;
import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>{

    private ArrayList<Character> list = new ArrayList<>();
     


    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CharacterViewHolder(ItemCharacterBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));

    }


    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void submitlist(List<Character> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder {

        private ItemCharacterBinding binding;

        public CharacterViewHolder(ItemCharacterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Character character) {
            Glide.with(binding.imageCharacter)
                    .load(character.getImage())
                    .into(binding.imageCharacter);
            binding.textCharacterFullName.setText(character.getName());

        }
    }
}
