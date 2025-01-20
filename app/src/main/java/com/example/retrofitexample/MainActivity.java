package com.example.retrofitexample;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitexample.Recycler.RecyclerAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerAdapter adapter = new RecyclerAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        TextView textoTarjeta = recyclerView.findViewById(R.id.textoTarjeta);
        ImageView ImagenTarjeta = recyclerView.findViewById(R.id.imagenTarjeta);
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Drinks> call = apiInterface.getGinDrinks();
        call.enqueue(new Callback<Drinks>() {
            @Override
            public void onResponse(Call<Drinks> call, Response<Drinks> response) {
                Log.d("Código", response.code() + "");
                Drinks drinks = response.body();
                String todoInfo = "";
                for(Drinks.Coctail cocktail : drinks.drinks){
                    todoInfo = todoInfo + cocktail.name + "\n";
                    textoTarjeta.setText(cocktail.name);
                    ImagenTarjeta.setImageURI(Uri.parse(cocktail.imageUrl));
                }
                Log.d("Toda la info", todoInfo);

            }

            @Override
            public void onFailure(Call<Drinks> call, Throwable throwable) {

            }

        });
    }
}