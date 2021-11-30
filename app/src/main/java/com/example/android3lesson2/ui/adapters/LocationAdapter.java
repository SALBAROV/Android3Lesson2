package com.example.android3lesson2.ui.adapters;


import android.location.Location;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android3lesson2.data.dtos.location.Locations;
import com.example.android3lesson2.databinding.ItemLocationBinding;

import java.util.ArrayList;
import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder> {


    private ArrayList<Locations> list = new ArrayList<>();



    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LocationViewHolder(ItemLocationBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));

    }



    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void submitList(List<Locations> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public class LocationViewHolder extends RecyclerView.ViewHolder {

        private ItemLocationBinding binding;

        public LocationViewHolder(ItemLocationBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Locations locations) {
            binding.textLocationFullName.setText(locations.getName());
            binding.textLocationDimension.setText(locations.getDimension());
            binding.textLocationType.setText(locations.getType());
        }
    }
}


