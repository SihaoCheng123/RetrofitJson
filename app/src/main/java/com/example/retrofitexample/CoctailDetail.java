package com.example.retrofitexample;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CoctailDetail {

    @SerializedName("drinks")
    List<Coctails> coctails = new ArrayList<>();

    public List<Coctails> getCoctails() {
        return coctails;
    }


    public static class Coctails{
        @SerializedName("idDrink")
        private String id;

        @SerializedName("strDrink")
        private String name;

        @SerializedName("strCategory")
        private String category;

        @SerializedName("strInstructionsES")
        private String instruction;

        public String getName() {
            return name;
        }

        public String getInstruction() {
            return instruction;
        }

        public String getCategory() {
            return category;
        }


        @Override
        public String toString() {
            return "Coctails{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", category='" + category + '\'' +
                    ", instruction='" + instruction + '\'' +
                    '}';
        }
    }
}