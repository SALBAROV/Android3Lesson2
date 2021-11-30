package com.example.android3lesson2.data.dtos;

import com.example.android3lesson2.data.dtos.episodes.Episodes;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RickyAndMortyResponce<T> {

    @SerializedName("info")
    private Info info;

    @SerializedName("results")
    private ArrayList<T> results;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(ArrayList<T> results) {
        this.results = results;
    }
}
