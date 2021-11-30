package com.example.android3lesson2.ui.fragments.character;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android3lesson2.App;
import com.example.android3lesson2.data.dtos.RickyAndMortyResponce;
import com.example.android3lesson2.data.dtos.character.Character;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharactersViewModel extends ViewModel {

    private final MutableLiveData<Boolean> _isLoading = new MutableLiveData<>();
    public final LiveData<Boolean> isLoading = _isLoading;

    public LiveData<RickyAndMortyResponce<Character>> fetchCharacter(){

    MutableLiveData<RickyAndMortyResponce<Character>> data = new MutableLiveData<>();
    App.characterApiService.fetchCharacters(id).enqueue(new Callback<RickyAndMortyResponce<Character>>() {
        @Override
        public void onResponse(Call<RickyAndMortyResponce<Character>> call, Response<RickyAndMortyResponce<Character>> response) {
            data.setValue(response.body());
        }

        @Override
        public void onFailure(Call<RickyAndMortyResponce<Character>> call, Throwable t) {
            data.setValue(null);
        }
    });
    return data;
    }


}


