package com.example.android3lesson2.ui.fragments.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android3lesson2.App;
import com.example.android3lesson2.data.dtos.RickyAndMortyResponce;
import com.example.android3lesson2.data.dtos.character.Character;

import java.util.HashMap;

import javax.security.auth.callback.Callback;

import retrofit2.Call;
import retrofit2.Response;

public class CharactersDetailViewModel extends ViewModel {
    private final MutableLiveData<Character> _character = new MutableLiveData<>();
    public final LiveData<Character> character = _character;

    private final MutableLiveData<Boolean> _isLoading = new MutableLiveData<>();
    public final LiveData<Boolean> isLoading = _isLoading;

//    public void fetchCharacter(int id) {
//        _isLoading.setValue(true);
//        App.characterApiService.fetchCharacter).enqueue(new Callback<Character>() {
//           @Override
//
//
//        }
//
//        }
//
//    });
//







