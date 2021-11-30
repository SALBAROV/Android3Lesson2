package com.example.android3lesson2.data.network.apiservices;

import com.example.android3lesson2.data.dtos.RickyAndMortyResponce;
import com.example.android3lesson2.data.dtos.character.Character;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CharacterApiService {

    @GET("/api/character/")
     Call<RickyAndMortyResponce<Character>> fetchCharacters(int id);

    @GET("/api/character/{id}")
    Call<RickyAndMortyResponce<Character>> fetchCharacter(
            @Path("id") int id
    );


}
