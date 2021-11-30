package com.example.android3lesson2.data.network;

import com.example.android3lesson2.data.network.apiservices.CharacterApiService;
import com.example.android3lesson2.data.network.apiservices.EpisodesApiService;
import com.example.android3lesson2.data.network.apiservices.LocationApiService;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


    private final OkHttpClient okHttpClient = new OkHttpClient()
            .newBuilder()
            .addInterceptor(provideLoggingInterceptor())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30,TimeUnit.SECONDS)
            .writeTimeout(30,TimeUnit.SECONDS)
            .build();

    private final HttpLoggingInterceptor provideLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build();

    public CharacterApiService provideCharacterApiService() {
        return retrofit.create(CharacterApiService.class);
    }
    public EpisodesApiService provideEpisodeApiService() {
        return retrofit.create(EpisodesApiService.class);
    }
    public LocationApiService provideLocationApiService() {
        return retrofit.create(LocationApiService.class);
    }


}
