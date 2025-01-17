package com.example.retrofitexample;

import com.google.gson.annotations.SerializedName;

public class Cocktail {
    @SerializedName("name")
    private String name;
    @SerializedName("iamge")
    private String imageUrl;
    @SerializedName("id")
    private String id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
