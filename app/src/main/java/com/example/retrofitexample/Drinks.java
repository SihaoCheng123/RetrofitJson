package com.example.retrofitexample;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Drinks {
    @SerializedName("drinks")
    List<Coctail> drinks = new ArrayList<>();

    public static class Coctail {
        @SerializedName("strDrink")
        public String name;
        @SerializedName("strDrinkThumb")
        public String imageUrl;
        @SerializedName("idDrink")
        public String id;
    }


}

