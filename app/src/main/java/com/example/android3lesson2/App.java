package com.example.android3lesson2;

import android.app.Application;

import com.example.android3lesson2.data.dtos.character.Character;
import com.example.android3lesson2.data.network.RetrofitClient;
import com.example.android3lesson2.data.network.apiservices.CharacterApiService;
import com.example.android3lesson2.data.network.apiservices.EpisodesApiService;
import com.example.android3lesson2.data.network.apiservices.LocationApiService;

public class App extends Application {

    public static CharacterApiService characterApiService;
    public static EpisodesApiService episodesApiService;
    public static LocationApiService locationApiService;

    @Override
    public void onCreate() {
        super.onCreate();

        RetrofitClient retrofit = new RetrofitClient();
        characterApiService = retrofit.provideCharacterApiService();
        episodesApiService = retrofit.provideEpisodeApiService();
        locationApiService = retrofit.provideLocationApiService();
    }

}