package com.example.android3lesson2.data.network.apiservices;

import android.location.Location;

import com.example.android3lesson2.data.dtos.RickyAndMortyResponce;
import com.example.android3lesson2.data.dtos.character.Character;
import com.example.android3lesson2.data.dtos.location.Locations;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LocationApiService {

   @GET("/api/location")
    Call<RickyAndMortyResponce<Locations>> fetchLocation();
}
