package com.example.android3lesson2.ui.fragments.location;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android3lesson2.App;
import com.example.android3lesson2.data.dtos.RickyAndMortyResponce;
import com.example.android3lesson2.data.dtos.location.Locations;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationViewModel extends ViewModel {

    private final MutableLiveData<Boolean> _isLoading = new MutableLiveData<>();
    public final LiveData<Boolean> isLoading = _isLoading;

    public LiveData<RickyAndMortyResponce<Locations>> fetchLocations(){
        MutableLiveData<RickyAndMortyResponce<Locations>> data = new MutableLiveData<>();
        App.locationApiService.fetchLocation().enqueue(new Callback<RickyAndMortyResponce<Locations>>() {
            @Override
            public void onResponse(Call<RickyAndMortyResponce<Locations>> call, Response<RickyAndMortyResponce<Locations>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<RickyAndMortyResponce<Locations>> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;



    }}


