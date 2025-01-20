package com.example.retrofitexample.Recycler;

import com.example.retrofitexample.Drinks;

public class RecyclerEventModel {
    public Drinks drinks;

    public RecyclerEventModel(Drinks drinks) {
        this.drinks = drinks;
    }

    public Drinks getDrinks() {
        return drinks;
    }

}
