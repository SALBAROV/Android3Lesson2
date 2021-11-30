package com.example.android3lesson2.data.network.apiservices;

import com.example.android3lesson2.data.dtos.RickyAndMortyResponce;
import com.example.android3lesson2.data.dtos.episodes.Episodes;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EpisodesApiService {

    @GET("/api/episode/")
    Call<RickyAndMortyResponce<Episodes>> fetchEpisodes();
}

