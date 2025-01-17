package com.example.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("cocktails-array.json")
    Call<List<Cocktail>> getCocktails();


}
