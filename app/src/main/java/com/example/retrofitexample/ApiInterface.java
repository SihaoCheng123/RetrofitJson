package com.example.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("filter.php?i=Gin")
    Call<Drinks> getGinDrinks();

    @GET("filter.php?i=Vodka")
    Call<Drinks> getVodkaDrinks();
}
