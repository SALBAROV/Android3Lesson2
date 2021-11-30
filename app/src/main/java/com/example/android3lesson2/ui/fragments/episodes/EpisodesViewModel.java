package com.example.android3lesson2.ui.fragments.episodes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android3lesson2.App;
import com.example.android3lesson2.data.dtos.RickyAndMortyResponce;
import com.example.android3lesson2.data.dtos.episodes.Episodes;
import com.example.android3lesson2.data.network.apiservices.EpisodesApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EpisodesViewModel extends ViewModel {

    private final MutableLiveData<Boolean> _isLoading = new MutableLiveData<>();
    public final LiveData<Boolean> isLoading = _isLoading;

    public LiveData<RickyAndMortyResponce<Episodes>> fetchEpisodes() {
        MutableLiveData<RickyAndMortyResponce<Episodes>> data = new MutableLiveData<>();
        App.episodesApiService.fetchEpisodes().enqueue(new Callback<RickyAndMortyResponce<Episodes>>() {
            @Override
            public void onResponse(Call<RickyAndMortyResponce<Episodes>> call, Response<RickyAndMortyResponce<Episodes>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<RickyAndMortyResponce<Episodes>> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;

    }



}

